package Commands;

import Managers.CollectionManager;

public class InfoComma extends AbstractCommand {

    public InfoComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
       return collectionManager.infoComma();

    }

}
