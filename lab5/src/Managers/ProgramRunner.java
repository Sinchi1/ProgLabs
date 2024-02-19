package Managers;

import Commands.*;
import Exceptions.RunnerException;

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
    }


    public void run() {
        boolean isFirstCom = true;
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                if (!isFirstCom) {
                    System.out.print("Ваша команда:");

                    String line = scan.nextLine();

                    String[] parts = line.split("\\s{1}", 2);

                    String commName = parts[0].toLowerCase();

                    if (commandManager.isCommandExists(commName)) {
                        AbstractCommand com = commandManager.getCommandByName(commName);

                        if (commandManager.isHavingArgument(commName) && (parts.length == 1)) {
                            System.out.println("Вы забыли аргумент команды!");
                            continue;
                        }

                        if(!(commandManager.isHavingArgument(commName)) && (parts.length)>1){
                            System.out.println("Вы перестарались и ввели лишний аргумент для команды! :)");
                            continue;
                        }

                        String commandArgument = "";

                        if (commandManager.isHavingArgument(commName)) {
                            commandArgument = parts[1];
                        }

                        String result = com.execute(commandArgument);

                        com.execute(commandArgument);

                        System.out.println(result);
                    } else {
                        System.out.println("К сожалению введённой команды не существует! :(");
                    }
                } else {
                    System.out.println("Для использования программы нужно знать команды, чтобы ознакомиться с ними" +
                            " введите команду help.\nЕсли же вы их знаете в добрый путь!");

                    isFirstCom = false;
                }
            } catch (RunnerException e) {
                System.exit(1); // Не очень понимаю как вызвать
            }
        }
    }
}
