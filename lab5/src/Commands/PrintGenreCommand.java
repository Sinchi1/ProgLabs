package Commands;

import Managers.CollectionManager;

public class PrintGenreCommand extends AbstractCommand  {

    public PrintGenreCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
        collectionManager.ascedGenreCommand();

    }

}
