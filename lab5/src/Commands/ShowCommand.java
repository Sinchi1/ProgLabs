package Commands;

import Collections.Movie;
import Managers.CollectionManager;
import Managers.ConsolePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * The class used to call the method and display its work
 */
public class ShowCommand extends AbstractCommand {

    public ShowCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager;
    /**
     * The method that printing all elements of collection
     * @return void
     */
    @Override
    public void execute(String args) {
       collectionManager = CollectionManager.getInstance();
       collectionManager.showAllElements();
    }

}
