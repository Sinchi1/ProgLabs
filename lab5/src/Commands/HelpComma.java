package Commands;

import Managers.CollectionManager;

public class HelpComma extends AbstractCommand  {

    public HelpComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }
    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        return collectionManager.helpComma();
    }

}
