package Commands;

import Managers.CollectionManager;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SaveCommand extends AbstractCommand {

    public SaveCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) throws JsonProcessingException {
        collectionManager.save();
    }

}
