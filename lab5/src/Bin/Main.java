package Bin;
import Collections.Coordinates;
import Managers.ConsolePrinter;
import Managers.ProgramRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    /**
     * Главный класс в котором происходит работа программы
     */
public static void main(String[] args) throws IOException {
    ProgramRunner runner = new ProgramRunner();
    runner.cmdAdd();
    ConsolePrinter consolePrinter = new ConsolePrinter();
    try {
        runner.run(args[0]);
    } catch (ArrayIndexOutOfBoundsException e) {
        ConsolePrinter.messageToConsole("Вы не ввели название файла!");
    }
}
}
