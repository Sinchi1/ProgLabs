package Commands;

import Managers.CollectionManager;

public class AddComma extends AbstractCommand {

    public AddComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }
    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        collectionManager.addCommand();
        return "Команда выполнена";
    }

}
