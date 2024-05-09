package Managers;

import Commands.*;
import Exceptions.RunnerException;
import ProgrammEnums.ProgrammState;
import sun.misc.Signal;

import java.io.*;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramRunner {
    private static String ScriptName;
    CommandManager commandManager = new CommandManager();
    XmlParser xmlParser = new XmlParser();
    ProgrammStateManager programmStateManager = ProgrammStateManager.getInstance();

    public void cmdAdd() {
        commandManager.registerCommand("help", new HelpCommand("Help", "вывести справку по доступным командам"));
        commandManager.registerCommand("info", new InfoCommand("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"));
        commandManager.registerCommand("show", new ShowCommand("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"));
        commandManager.registerCommand("clear", new ClearCommand("clear", "очистить коллекцию"));
        commandManager.registerCommand("add", new AddCommand("add", "добавить новый элемент в коллекцию"));
        commandManager.registerCommand("exit", new ExitCommand("exit", "завершить программу (без сохранения в файл)"));
        commandManager.registerCommand("save", new SaveCommand("save", "сохранить коллекцию в файл"));
        commandManager.registerCommand("remove_by_id", new RemoveByIdCommand("remove_by_id", "удалить элемент из коллекции по его id"));
        commandManager.registerCommand("head", new HeadCommand("head", "вывести первый элемент коллекции"));
        commandManager.registerCommand("print_genre", new PrintGenreCommand("print_genre", "Выводит все жанры использованные в коллекции"));
        commandManager.registerCommand("filter_by_name", new FilterNameCommand("filter_by_name", "Показывает количество элементов начинающихся c указанной подстроки"));
        commandManager.registerCommand("remove_lower", new RemoveLowerCommand("remove_lower", "Удаляет все элементы коллекции, чьё id < указанного пользователем"));
        commandManager.registerCommand("remove_any_by_oscars_count", new RemoveOscarCountCommand("remove_any_by_oscars_count", "удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному"));
        commandManager.registerCommand("save", new SaveCommand("save", "сохранить коллекцию в файл"));
        commandManager.registerCommand("update_id", new UpdateIdCommand("update_id", "обновить значение элемента коллекции, id которого равен заданному"));
        commandManager.registerCommand("execute_script", new ExecuteScriptCommand("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде в котором их вводит пользователь в интерактивном режиме."));
    }

    public void run(String path) throws IOException {
        boolean isFirstCom = true;
        boolean flagSearch = false;
        Thread thread = new Thread(() -> {
            System.out.println("\nВыход из программы");
            try {
                CollectionManager collectionManager = CollectionManager.getInstance();
                ConsolePrinter.messageToConsole(collectionManager.saveCollection());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        Scanner scan = new Scanner(System.in);
        try {
            xmlParser.deserializeCollection(path);
        } catch (IOException e) {
            do {
                File file = null;
                try {
                    file = new File(path);
                    xmlParser.deserializeCollection(path);
                    flagSearch = true;
                } catch (IOException b) {
                    if (file.exists() && file.canRead() && file.canWrite()) {
                        System.out.println("Файл не валиден и будет очищен");
                        FileWriter writer = new FileWriter(path);
                        writer.write("<LinkedList></LinkedList>");
                        writer.close();
                        xmlParser.deserializeCollection(path);
                        break;
                    }
                    if (!file.exists()) {
                        ConsolePrinter.messageToConsole("Файл не существует. Будет создан файл по пути " + path);
                        file.createNewFile();
                        FileWriter writer = new FileWriter(path);
                        writer.write("<LinkedList></LinkedList>");
                        writer.close();
                        xmlParser.deserializeCollection(path);
                        break;
                    } else if (file.exists() && !file.canRead() && !file.canWrite()) {
                        ConsolePrinter.messageToConsole("Файл по пути " + path + "  не обладает правами записи и чтения, введите другой файл");
                        break;
                    } else if (file.exists() && !file.canRead()) {
                        ConsolePrinter.messageToConsole("Файл по пути " + path + " нельзя прочесть, введите другой файл");
                        break;
                    } else if (file.exists()  && !file.canWrite()) {
                        ConsolePrinter.messageToConsole("Файл по пути " + path + "  не обладает правами записи, введите другой файл");
                        break;
                    }
                } catch (NoSuchElementException b) {
                    ConsolePrinter.messageToConsole("Неожиданное сочетание клавиш!");
                    return;
                }
            }
            while (!flagSearch);
        }
        Runtime.getRuntime().addShutdownHook(thread);
        while (true) {
            programmStateManager =  ProgrammStateManager.getInstance();
            if (programmStateManager.getProgrammState() == ProgrammState.PROGRAMM_STATE_PASSIVE){
                ConsolePrinter.messageToConsole("Скрипт Выполнен!");
            }
            programmStateManager.setProgrammState(ProgrammState.PROGRAMM_STATE_ACTIVE);
            try {
                if (!isFirstCom) {
                    ConsolePrinter.messageToConsoleWithoutLn("Ваша команда:");
                    String line = null;
                    try {
                        Thread.sleep(1);
                        line = scan.nextLine().trim();
                    } catch (NoSuchElementException | InterruptedException ignored) {
                        thread.interrupt();
                        System.exit(1);
                    }
                    if (line.equalsIgnoreCase("exit")){
                        Runtime.getRuntime().removeShutdownHook(thread);
                    }
                    String[] parts = line.split("\\s+", 2);
                    String commName = parts[0].toLowerCase();
                    if (commandManager.isCommandExists(commName)) {
                        AbstractCommand com = commandManager.getCommandByName(commName);
                        if (commandManager.isHavingArgument(commName) && (parts.length == 1)) {
                            ConsolePrinter.messageToConsole("Вы забыли аргумент команды!");
                            continue;
                        }
                        if ((commandManager.isHavingArgument(commName)) && (parts[1].split("\\s{1}", 2)).length > 1) {
                            ConsolePrinter.messageToConsole("Вы перестарались и ввели лишний аргумент для команды!");
                            continue;
                        }
                        String commandArgument = "";
                        if (commandManager.isHavingArgument(commName)) {
                            commandArgument = parts[1];
                        }
                        com.execute(commandArgument);
                    } else {
                        ConsolePrinter.messageToConsole("К сожалению, введённой команды не существует!");
                    }
                } else {
                    ConsolePrinter.messageToConsole("Для использования программы нужно знать команды, чтобы ознакомиться с ними" +
                            " введите команду help.\nЕсли же вы их знаете в добрый путь!");
                    isFirstCom = false;
                }
            } catch (RunnerException e) {
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    HashSet<String> corrector = new HashSet<>();
    public void runOnce(String args) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args));
        } catch (FileNotFoundException e) {
            ConsolePrinter.messageToConsole("Такого файла скрипта не существует!");
            return;
        }
        ScriptName = args;
        programmStateManager = ProgrammStateManager.getInstance();
        programmStateManager.setProgrammState(ProgrammState.PROGRAMM_STATE_PASSIVE);
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            String[] parts = line.split("\\s+", 2);
            String commName = parts[0].toLowerCase();
            if (commandManager.isCommandExists(commName)) {
                AbstractCommand com = commandManager.getCommandByName(commName);
                if (commandManager.isHavingArgument(commName) && (parts.length == 1)) {
                    ConsolePrinter.messageToConsole("Вы забыли аргумент команды!");
                    break;
                }
                if ((commandManager.isHavingArgument(commName)) && (parts[1].split("\\s{1}", 2)).length > 1) {
                    ConsolePrinter.messageToConsole("Вы перестарались и ввели лишний аргумент для команды!");
                    break;
                }
                String commandArgument = "";
                if (commandManager.isHavingArgument(commName)) {
                    commandArgument = parts[1];
                }
                if (commName.equals("execute_script") && corrector.contains(commandArgument)){
                    System.out.println("Доступна только одна итерация скрипта!");
                    break;
                }

                if (commName.equals("execute_script")){
                    corrector.add(commandArgument);
                }

                com.execute(commandArgument);
            }
        }
        corrector.clear();
    }

    public String getScriptName() {
        return ScriptName;
    }
}
