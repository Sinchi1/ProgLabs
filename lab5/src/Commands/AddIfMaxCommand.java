package Commands;

import Managers.CollectionManager;

public class AddIfMaxCommand extends AbstractCommand  {

    public AddIfMaxCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.infoComma();

    }

}
