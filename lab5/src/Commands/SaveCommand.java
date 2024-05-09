package Commands;

import Managers.CollectionManager;
import Managers.ConsolePrinter;
import Managers.XmlParser;
import com.fasterxml.jackson.core.JsonProcessingException;
/**
 * The class used to call the method and display its work
 */
public class SaveCommand extends AbstractCommand {

    public SaveCommand(String name, String description) {
        super(name, description);
    }
    CollectionManager collectionManager;
    /**
     * The method that printing that collection was saved
     * @return void
     */
    @Override
    public void execute(String args) throws JsonProcessingException {
        collectionManager = CollectionManager.getInstance();
        ConsolePrinter.messageToConsole(collectionManager.saveCollection());
    }
}
