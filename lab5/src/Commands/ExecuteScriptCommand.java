package Commands;

import Managers.CollectionManager;
import Managers.ConsolePrinter;
import Managers.ProgramRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * The class used to call the method and display its work
 */
public class ExecuteScriptCommand extends AbstractCommand{
    public ExecuteScriptCommand(String name, String description) {
        super(name, description);
    }
    ProgramRunner programRunner = new ProgramRunner();
    /**
     * The method used to execute scripts
     * @return void
     */
    @Override
    public void execute(String args) throws IOException {
        programRunner.runOnce(args);
    }
}
