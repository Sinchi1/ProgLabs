package Commands;

import Managers.CollectionManager;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SaveComma extends AbstractCommand {

    public SaveComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) throws JsonProcessingException {
        collectionManager.save();
        return "";
    }

}
