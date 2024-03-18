package Commands;

import Managers.CollectionManager;

public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.execute_script(args);
    }
}
