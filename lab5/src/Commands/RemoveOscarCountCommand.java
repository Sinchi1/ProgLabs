package Commands;

import Collections.Movie;
import Managers.CollectionManager;
import Managers.ConsolePrinter;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * The class used to call the method and display its work
 */
public class RemoveOscarCountCommand extends AbstractCommand {

    public RemoveOscarCountCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager;

    ConsolePrinter consolePrinter = new ConsolePrinter();
    /**
     * The method that printing information about deleted elements,which contained right amout of Oscars
     * @return void
     */
    @Override
    public void execute(String args) {
        collectionManager = CollectionManager.getInstance();
        ConsolePrinter.messageToConsole(collectionManager.removeOscar(args).toString().replaceAll("^\\[|\\]$", ""));
    }

}
