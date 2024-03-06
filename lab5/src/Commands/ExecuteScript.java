package Commands;

import Managers.CollectionManager;

public class ExecuteScript extends AbstractCommand{
    public ExecuteScript(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        return collectionManager.execute_script(args);
    }
}
