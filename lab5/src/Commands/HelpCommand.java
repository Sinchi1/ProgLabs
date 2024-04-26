package Commands;

import Managers.CommandManager;
import Managers.ConsolePrinter;

import java.util.HashMap;
import java.util.Map;
/**
 * The class used to call the method and display its work
 */
public class HelpCommand extends AbstractCommand  {

    public HelpCommand(String name, String description) {
        super(name, description);
    }

    CommandManager commandManager = new CommandManager();
    /**
     * The method that printing all commands of the programm
     * @return void
     */
    @Override
    public void execute(String args) {
        HashMap<String, AbstractCommand> commandHashMap = commandManager.getCommandHashMap();
        for (Map.Entry<String, AbstractCommand> entry : commandHashMap.entrySet()){
            ConsolePrinter.messageToConsole("Описание: " +entry.getValue());
        }
    }

}
