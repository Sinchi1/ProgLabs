package Commands;

import Managers.CollectionManager;

public class ClearCommand extends AbstractCommand  {

    public ClearCommand(String name, String description) {
        super(name, description);
    }
    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
       collectionManager.clearCommand();

    }

}
