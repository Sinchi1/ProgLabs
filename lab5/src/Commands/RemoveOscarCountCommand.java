package Commands;

import Managers.CollectionManager;

public class RemoveOscarCountCommand extends AbstractCommand {

    public RemoveOscarCountCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.removeOneOscar(args);
    }

}
