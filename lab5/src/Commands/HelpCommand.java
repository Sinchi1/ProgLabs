package Commands;

import Managers.CollectionManager;

public class HelpCommand extends AbstractCommand  {

    public HelpCommand(String name, String description) {
        super(name, description);
    }
    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.helpComma();
    }

}
