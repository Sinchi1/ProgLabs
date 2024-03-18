package Commands;

import Managers.CollectionManager;

public class RemoveLowerCommand extends AbstractCommand {

    public RemoveLowerCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
    collectionManager.removeLower(args);
    }

}
