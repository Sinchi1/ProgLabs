package Commands;

import Managers.CollectionManager;

public class InfoCommand extends AbstractCommand {

    public InfoCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.infoComma();

    }

}
