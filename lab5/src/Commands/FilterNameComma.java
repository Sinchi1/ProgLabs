package Commands;

import Managers.CollectionManager;

public class FilterNameComma extends AbstractCommand  {

    public FilterNameComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        collectionManager.infoComma();
        return "Команда выполнена";
    }

}
