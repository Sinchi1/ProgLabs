package Commands;

import Collections.Movie;
import Managers.CollectionManager;
import Managers.ConsolePrinter;

import java.util.LinkedList;
/**
 * The class used to call the method and display its work
 */
public class InfoCommand extends AbstractCommand {

    public InfoCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager;

    ConsolePrinter consolePrinter = new ConsolePrinter();
    /**
     * The method that printing all information about collection
     * @return void
     */
    @Override
    public void execute(String args) {
        collectionManager = CollectionManager.getInstance();
        ConsolePrinter.messageToConsole(collectionManager.getCollectionInfo());
    }

}
