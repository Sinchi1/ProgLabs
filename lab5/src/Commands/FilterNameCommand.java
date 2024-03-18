package Commands;

import Managers.CollectionManager;

public class FilterNameCommand extends AbstractCommand  {

    public FilterNameCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.filterStartsWithName(args);
    }

}
