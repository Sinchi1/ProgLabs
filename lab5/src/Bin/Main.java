package Bin;

import Commands.*;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.ProgrammRunner;

import java.util.Scanner;

public class Main {
public static void main(String[] args){
    CommandManager commandManager = new CommandManager();
    CollectionManager collectionManager = new CollectionManager();
    ProgrammRunner runner = new ProgrammRunner();

    runner.cmdAdd();

    runner.run();
}
}
