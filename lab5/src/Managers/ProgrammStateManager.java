package Managers;

import ProgrammEnums.ProgrammState;
/**
 * The singleton class that's contains information about reading mode
 */
public class ProgrammStateManager {
    private static volatile ProgrammStateManager instance;

    private ProgrammState programmState;

    public static ProgrammStateManager getInstance() {
        ProgrammStateManager localInstance = instance;
        if (localInstance == null) {
            synchronized (ProgrammStateManager.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ProgrammStateManager();
                }
            }
        }
        return localInstance;
    }

    public ProgrammState getProgrammState(){
        return programmState;
    }

    public void setProgrammState(ProgrammState programmState){
        this.programmState = programmState;
    }

}
