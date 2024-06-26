package project.Server;

import project.Common.Request;
import project.Common.Response;
import project.Main;
import project.Managers.ConsolePrinter;
import project.Managers.DeSerializer;
import project.Managers.Serializer;
import project.Util.RequestHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
    private static final int port = 1212;
    private static final String host = "localhost";
    private int soTimeout;
    private ServerSocketChannel serverSocket;
    private static final RequestHandler requestHandler = new RequestHandler();

    private static final ByteBuffer buffer = ByteBuffer.allocate(4096);

    private Selector selector;

    public void runServer(){
        ConsolePrinter.messageToConsole("Сервер готов для операций...");
        try{
            while(true){
                selector.selectNow();
                Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
                while (selectedKeys.hasNext()) {
                    SelectionKey key = takeKey(selectedKeys);
                    operateKey(key);
                }
            }
        } catch (IOException e) {
            ConsolePrinter.errorMessage("Неудачный набор ключей");
            System.exit(1);
        }
    }

    private Selector launchSelector() {
        try {
            Selector selector = Selector.open();
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);
            return selector;
        } catch (IOException e) {
            ConsolePrinter.errorMessage("Неудачное создание селектора");
            System.exit(1);
            return null;
        }
    }

    private SelectionKey takeKey(Iterator<SelectionKey> selectionKeyIterator){
        SelectionKey key = selectionKeyIterator.next();
        selectionKeyIterator.remove();
        return key;
    }

    private void operateKey(SelectionKey key) {
        try {
            if (key.isValid()) {
                if (key.isAcceptable()) {
                    accept(key);
                } else if (key.isReadable()) {
                    read(key);
                } else if (key.isWritable()) {
                    write(key);
                }
            }
        } catch (IOException e) {
            ConsolePrinter.errorMessage("Запись невозможна");
            System.exit(1);
        }
    }

    public void openServerConnection(){
        try {
            serverSocket = ServerSocketChannel.open();
            serverSocket.configureBlocking(false);
            serverSocket.bind(new InetSocketAddress(host, port));
            selector = launchSelector();
            ConsolePrinter.messageToConsole("Сервер открыт для подключен...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(SelectionKey key) {
        try {
            ConsolePrinter.messageToConsole("Производится Операция Чтения...");
            SocketChannel socketChannel = (SocketChannel) key.channel();
            buffer.clear();
            int byteRead;
            try {
                byteRead = socketChannel.read(buffer);
            } catch (IOException e) {
                key.cancel();
                socketChannel.close();
                return;
            }
            if (byteRead == -1){
                key.cancel();
                return;
            }
            buffer.flip();
            Request request = DeSerializer.deSerializeRequest(buffer);
            Response response = requestHandler.handle(request);
            socketChannel.register(selector, SelectionKey.OP_WRITE, response);
            ConsolePrinter.messageToConsole("Операция завершена успешно");
        } catch (IOException e) {
            ConsolePrinter.errorMessage("Не удалось изменить состояние канала");
            System.exit(1);
        }

    }

    private void write(SelectionKey key) throws IOException {
        ConsolePrinter.messageToConsole("Производится операция записи...");
        SocketChannel socketChannel = (SocketChannel) key.channel();
        Response response = (Response) key.attachment();
        ByteBuffer writeBuffer = Serializer.serialize(response);
        writeBuffer.flip();
        while (writeBuffer.hasRemaining()){
            socketChannel.write(writeBuffer);
        }
        socketChannel.register(selector, SelectionKey.OP_READ);
        ConsolePrinter.messageToConsole("Операция завершена успешно");
    }

    private void accept(SelectionKey key){
        try {
            SocketChannel socketChannel = serverSocket.accept();
            socketChannel.configureBlocking(false);
            ConsolePrinter.messageToConsole("Подключен пользователь " + socketChannel.getRemoteAddress().toString());
            socketChannel.register(selector, SelectionKey.OP_READ);
        } catch (IOException e) {
            ConsolePrinter.errorMessage("Не удалось изменить состояние канала");
            System.exit(1);
        }
    }

}
