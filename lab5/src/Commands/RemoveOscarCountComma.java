package Commands;

import Managers.CollectionManager;

public class RemoveOscarCountComma extends AbstractCommand {

    public RemoveOscarCountComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        collectionManager.removeOneOscar(args);
        return "";
    }

}
