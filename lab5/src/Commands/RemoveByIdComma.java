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
        int movieId = 0;
        movieId = Integer.parseInt(args); // Try catch block
        collectionManager.removeById(movieId);
        return "Команда выполнена";
    }
}
