package Commands;

import Managers.CollectionManager;

public class HeadCommand extends AbstractCommand  {
    public HeadCommand(String name, String description) {
        super(name, description);
    }
    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.headCommand();
    }

}
