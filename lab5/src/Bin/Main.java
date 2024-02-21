package Bin;

import Collections.Movie;
import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.ProgramRunner;
import Managers.XmlParser;

import java.util.LinkedList;


public class Main {
public static void main(String[] args){
    CommandManager commandManager = new CommandManager();
    CollectionManager collectionManager = new CollectionManager();
    ProgramRunner runner = new ProgramRunner();
    XmlParser xmlParser = new XmlParser();


    runner.cmdAdd();

    runner.run();
}
}
