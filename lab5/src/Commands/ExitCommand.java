package Commands;

import Managers.CollectionManager;
import Managers.ConsolePrinter;

public class ExitCommand extends AbstractCommand{
    public ExitCommand(String name, String description) {
        super(name, description);
    }

    CollectionManager collectionManager = new CollectionManager();

    @Override
    public void execute(String args) {
            ConsolePrinter.messageToConsole("Программа успешно прекращена! (Без сохранения)");
            System.exit(1);


    }
}
