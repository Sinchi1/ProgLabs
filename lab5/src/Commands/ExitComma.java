package Commands;

import Managers.CollectionManager;

public class ExitComma extends AbstractCommand{
    public ExitComma(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        collectionManager.exitCommand();
        return  null;
    }
}
