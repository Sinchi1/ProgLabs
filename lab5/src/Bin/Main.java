package Bin;
import Managers.ProgramRunner;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    /**
     * Главный класс в котором происходит работа программы
     */
public static void main(String[] args) throws IOException {
    ProgramRunner runner = new ProgramRunner();
    runner.cmdAdd();
//    runner.run(args[0]);
     runner.run(Arrays.toString(args));
    }
}