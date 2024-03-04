package Commands;

import Managers.CollectionManager;

public class RemoveByIdComma extends AbstractCommand {

    public RemoveByIdComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }
    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        collectionManager.removeById(args);
        return "Команда выполнена";
    }
}
