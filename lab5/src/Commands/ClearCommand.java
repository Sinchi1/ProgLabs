package Commands;

import Collections.Movie;
import Managers.CollectionManager;
import Managers.ConsolePrinter;

import java.util.LinkedList;
/**
 * The class used to call the method and display its work
 */
public class ClearCommand extends AbstractCommand  {

    public ClearCommand(String name, String description) {
        super(name, description);
    }
    CollectionManager moviesCollection;
    /**
     * The method that admitting that collection was cleared
     * @return void
     */
    @Override
    public void execute(String args) {
        moviesCollection = CollectionManager.getInstance();
        moviesCollection.clearCollection();
        ConsolePrinter.messageToConsole("Коллекция:" + moviesCollection.getClass().getSimpleName() + " Успешно очищена!");
    }

}


