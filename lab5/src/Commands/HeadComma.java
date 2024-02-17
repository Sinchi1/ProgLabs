package Commands;

import Managers.CollectionManager;

public class HeadComma extends AbstractCommand  {

    public HeadComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }
    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        collectionManager.headCommand();
        return "Команда выполнена";
    }


}
