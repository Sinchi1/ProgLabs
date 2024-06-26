package project;

import project.Managers.ProgramController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

//        ProgramController programController = new ProgramController();
//
//        programController.run();

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        arrayList.stream().filter(v -> {
            System.out.println(v);
            return v > 1;
        }).collect(Collectors.toList());





    }

//    public interface Message{
//        String getmessage();
//    }
//
//    public class TextMessage implements Message{
//        private String content;
//        TextMessage(String content) {
//            this.content = content;
//        }
//
//        @Override
//        public String getmessage() {
//            return content;
//        }
//    }
//
//    public abstract class MessageDecorator implements  Message{
//        protected Message decoratedMessage;
//
//        public MessageDecorator(Message decoratedMessage){
//            this.decoratedMessage = decoratedMessage;
//        }
//        @Override
//        public String getmessage(){
//            return decoratedMessage.getmessage();
//        }
//    }
//
//    public class HtmlEncodedMessage extends MessageDecorator {
//
//        public HtmlEncodedMessage(Message decoratedMessage) {
//            super(decoratedMessage);
//        }
//
//        @Override
//        public String getmessage() {
//            return htmlEncode(decoratedMessage.getmessage());
//        }
//
//        private String htmlEncode(String content) {
//            return content.replace("<", "&lt;").replace(">", "&gt;");
//        }


    public interface Message{
        String getContent();
    }

    public class TextMessage implements Message{
        public String content;

        public TextMessage(String content){
            this.content = content;
        }

        @Override
        public String getContent() {
            return content;
        }
    }

    public abstract class TextMessageDecorator implements Message{
        protected Message message;

        TextMessageDecorator(Message message){
            this.message = message;
        }

        @Override
        public String getContent() {
            return message.getContent();
        }
    }

    public class EncodedMessage extends TextMessageDecorator{
        EncodedMessage(Message message){
            super(message);
        }

        @Override
        public String getContent() {
            return encode(super.getContent());
        }

        public String encode(String string){
            string.toUpperCase();
            return string;
        }
    }



}