package Commands;

import Collections.Movie;
import Managers.CollectionManager;
import Managers.ConsolePrinter;

import java.util.LinkedList;
/**
 * The class used to call the method and display its work
 */
public class HeadCommand extends AbstractCommand  {
    public HeadCommand(String name, String description) {
        super(name, description);
    }
    CollectionManager collectionManager;

    ConsolePrinter consolePrinter = new ConsolePrinter();
    /**
     * The method used to print first element of collection
     * @return void
     */
    @Override
    public void execute(String args) {
        collectionManager = CollectionManager.getInstance();
        ConsolePrinter.messageToConsole(collectionManager.findHeadOfCollection());
    }

}
