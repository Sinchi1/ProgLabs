package Commands;

import Managers.CollectionManager;

public class UpdateIdComma extends AbstractCommand {

    public UpdateIdComma(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        collectionManager.update_id(args);
        return "";
    }

}
