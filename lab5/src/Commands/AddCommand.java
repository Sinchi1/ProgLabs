package Commands;

import Managers.CollectionManager;

public class AddCommand extends AbstractCommand {

    public AddCommand(String name, String description) {
        super(name, description);
    }
    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.addCommand(args);

    }

}
