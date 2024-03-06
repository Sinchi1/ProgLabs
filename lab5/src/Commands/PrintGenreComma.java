package Commands;

import Managers.CollectionManager;

public class PrintGenreComma extends AbstractCommand  {

    public PrintGenreComma(String name, String description) {
        super(name, description);
        //TODO Auto-generated constructor stub
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public String execute(String args) {
        collectionManager.ascedGenreCommand();
        return "";
    }

}
