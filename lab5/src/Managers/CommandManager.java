package Managers;

import Commands.AbstractCommand;

import java.util.HashMap;
import java.util.LinkedList;

public class CommandManager {

    private final HashMap<String, AbstractCommand> commandHashMap = new HashMap<>();

    public HashMap<String, AbstractCommand> getCommands() {
        return commandHashMap;
    }

    public AbstractCommand getCommandByName(String name){
        return commandHashMap.get(name);
    }

    public void registerCommand(String commandName, AbstractCommand command){
        commandHashMap.put(commandName,command);
    }

    public boolean isCommandExists(String command) {
        return commandHashMap.containsKey(command);
    }

    public boolean isHavingArgument(String command){
        switch (command){
            case "add", "update_id","remove_by_id","execute_script","add_if_max",
                 "remove_any_by_oscars_count",
                 "remove_lower","filter_starts_with_name"-> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

}
