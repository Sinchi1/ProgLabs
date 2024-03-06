package Managers;

import Commands.*;
import Exceptions.RunnerException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ProgramRunner {

    CommandManager commandManager = new CommandManager();
    CollectionManager collectionManager = new CollectionManager();

    public void cmdAdd() {
        commandManager.regCommand("help", new HelpComma("Help", "Выводит инф"));
        commandManager.regCommand("info", new InfoComma("Help", "Выводит инф"));
        commandManager.regCommand("show", new ShowComma("Help", "Выводит инф"));
        commandManager.regCommand("clear", new ClearComma("Help", "Выводит инф"));
        commandManager.regCommand("add", new AddComma("Help", "Выводит инф"));
        commandManager.regCommand("exit", new ExitComma("Help", "Выводит инф"));
        commandManager.regCommand("save", new SaveComma("Help", "Выводит инф"));
        commandManager.regCommand("remove_by_id", new RemoveByIdComma("Help", "я натурал"));
        commandManager.regCommand("head", new HeadComma("Help", "Выводит инф"));
        commandManager.regCommand("print_genre", new PrintGenreComma("Help", "Выводит инф"));
        commandManager.regCommand("remove_lower", new RemoveLowerComma("Help", "Выводит инф"));
        commandManager.regCommand("remove_any_by_oscars_count", new RemoveOscarCountComma("Help", "Выводит инф"));
        commandManager.regCommand("save", new SaveComma("Help", "Выводит инф"));
        commandManager.regCommand("update_id", new UpdateIdComma("Help", "Выводит инф"));
        commandManager.regCommand("execute_script", new ExecuteScript("",""));
    }


    public void run() {
        boolean isFirstCom = true;
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                if (!isFirstCom) {
                    System.out.print("Ваша команда:");

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
                            System.out.println("Вы забыли аргумент команды!");
                            continue;
                        }

                        if((commandManager.isHavingArgument(commName)) && (parts[1].split("\\s{1}",2)).length>1){
                            System.out.println("Вы перестарались и ввели лишний аргумент для команды!");
                            continue;
                        }

                        String commandArgument = "";

                        if (commandManager.isHavingArgument(commName)) {
                            commandArgument = parts[1];
                        }

                        String result = com.execute(commandArgument);

                        System.out.println(result);

                    } else {
                        System.out.println("К сожалению, введённой команды не существует!");
                    }
                } else {
                    System.out.println("Для использования программы нужно знать команды, чтобы ознакомиться с ними" +
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
