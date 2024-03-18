package Managers;

import Commands.*;
import Exceptions.RunnerException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramRunner {

    CommandManager commandManager = new CommandManager();
    XmlParser xmlParser = new XmlParser();

    ConsolePrinter consolePrinter = new ConsolePrinter();

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
        commandManager.registerCommand("print_genre", new PrintGenreCommand("print_genre", "Выводит инф"));
        commandManager.registerCommand("remove_lower", new RemoveLowerCommand("remove_lower", "Выводит инф"));
        commandManager.registerCommand("remove_any_by_oscars_count", new RemoveOscarCountCommand("remove_any_by_oscars_count", "удалить из коллекции один элемент, значение поля oscarsCount которого эквивалентно заданному"));
        commandManager.registerCommand("save", new SaveCommand("save", "сохранить коллекцию в файл"));
        commandManager.registerCommand("update_id", new UpdateIdCommand("update_id", "обновить значение элемента коллекции, id которого равен заданному"));
        commandManager.registerCommand("execute_script", new ExecuteScriptCommand("execute_script","считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,\n" +
                "                    в котором их вводит пользователь в интерактивном режиме."));
    }

    public void run() {
        boolean isFirstCom = true;
        boolean flagSearch = false;
        Scanner scan = new Scanner(System.in);
        String path;
        do {
            try {
                ConsolePrinter.messageToConsoleWithoutLn("Введите имя файла: ");
                path = scan.nextLine();
                xmlParser.deserializeCollection(path);
                flagSearch = true;
            } catch (IOException e) {
                ConsolePrinter.messageToConsole("Такого файла не существует!\nВведите его ещё раз!");
            }
        }
        while (!flagSearch);
        while (true) {
            try {
                if (!isFirstCom) {
                    ConsolePrinter.messageToConsoleWithoutLn("Ваша команда:");

                    String line = null;

                    try {
                        line = scan.nextLine().trim();
                    } catch (NoSuchElementException e) {
                        throw new RuntimeException("Введена запрещённая комбинация клавиш!");
                    }

                    String[] parts = line.split("\\s+", 2);

                    String commName = parts[0].toLowerCase();

                    if (commandManager.isCommandExists(commName)) {
                        AbstractCommand com = commandManager.getCommandByName(commName);

                        if (commandManager.isHavingArgument(commName) && (parts.length == 1)) {
                            ConsolePrinter.messageToConsole("Вы забыли аргумент команды!");
                            continue;
                        }

                        if((commandManager.isHavingArgument(commName)) && (parts[1].split("\\s{1}",2)).length>1){
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
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
