package Commands;

import Managers.CollectionManager;

public class SaveComma extends AbstractCommand {

    public SaveComma(String name, String description) {
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
