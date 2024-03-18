package Commands;

import Managers.CollectionManager;

public class UpdateIdCommand extends AbstractCommand {

    public UpdateIdCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.update_id(args);
    }

}
