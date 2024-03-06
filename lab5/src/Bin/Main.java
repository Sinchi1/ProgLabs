package Bin;

import Managers.CollectionManager;
import Managers.CommandManager;
import Managers.ProgramRunner;
import Managers.XmlParser;

import java.io.IOException;

public class Main {
public static void main(String[] args) throws IOException {

    CommandManager commandManager = new CommandManager();
    CollectionManager collectionManager = new CollectionManager();
    ProgramRunner runner = new ProgramRunner();
    XmlParser xmlParser = new XmlParser();

    xmlParser.deserializeCollection("Test.xml");

    runner.cmdAdd();

    runner.run();

}
}
