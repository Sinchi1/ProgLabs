package Managers;

import Commands.*;

import java.util.Scanner;

public class ProgrammRunner {

    CommandManager commandManager = new CommandManager();
    CollectionManager collectionManager = new CollectionManager();
    public void cmdAdd() {
        commandManager.regCommand("help", new HelpComma("Help","Выводит инф"));
        commandManager.regCommand("info", new InfoComma("Help","Выводит инф"));
        commandManager.regCommand("show", new ShowComma("Help","Выводит инф"));
        commandManager.regCommand("clear", new ClearComma("Help","Выводит инф"));
        commandManager.regCommand("add", new AddComma("Help","Выводит инф"));
        commandManager.regCommand("exit", new ExitComma("Help","Выводит инф"));
        commandManager.regCommand("save", new SaveComma("Help","Выводит инф"));
        commandManager.regCommand("remove_by_id", new RemoveByIdComma("Help","я натурал"));
    }
// ne moe
    public void run() {
        boolean isFirstCommand = true;
        try {
            while (true) {
                if (!isFirstCommand) {
                    Scanner customScanner = new Scanner(System.in);

                    String line =customScanner.nextLine();

                    if (line.isEmpty()) {
                        System.out.println("$");
                        continue;
                    }

                    String[] parts = line.split("\\s+", 2);
                    String commandName = parts[0].toLowerCase();

                    if (commandManager.isCommandExists(commandName)) {
                        AbstractCommand com = commandManager.getCommandByName(commandName);

                        if (com == null) {
                            System.out.println("Команда не найдена.");
                        } else if (commandManager.isHavingArgument(commandName) && !(parts.length > 1)) {
                            System.out.println("Ошибка: команда " + commandName + " требует аргумента рядом.");
                        } else {
                            String argument = "";
                            if (parts.length > 1) {
                                argument = parts[1];
                            }
                            String result = com.execute(argument);
                            System.out.println(result);
                        }
                    } else {
                        System.out.println("Команда введена неправильно. Используйте help.");
                    }
                } else {
                    System.out.print("Введите команду: \n");
                }

                isFirstCommand = false;
            }
        } catch (RuntimeException e) {
            System.out.println("Произошло закрытие потока. Файл сохранен");
            System.exit(1);
        }
    }
}
