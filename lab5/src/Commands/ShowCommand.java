package Commands;

import Managers.CollectionManager;

public class ShowCommand extends AbstractCommand {

    public ShowCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
       collectionManager.showComma();
    }

}
