package Managers;

import Commands.AbstractCommand;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
/**
 * The class that contains information about Commands
 */
public class CommandManager {

    private static final LinkedHashMap<String, AbstractCommand> commandHashMap = new LinkedHashMap<>();
    public LinkedHashMap<String, AbstractCommand> getCommands() {
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
                 "remove_lower","filter_by_name"-> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public boolean insertNeededCommand(String command){
        switch (command){
            case "add","update_id" ->{
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public HashMap<String, AbstractCommand> getCommandHashMap(){
        return commandHashMap;
    }

}
