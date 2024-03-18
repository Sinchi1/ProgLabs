package Bin;
import Managers.ProgramRunner;

import java.io.IOException;

public class Main {
public static void main(String[] args){
    ProgramRunner runner = new ProgramRunner();
    runner.cmdAdd();
    runner.run();
    }
}
