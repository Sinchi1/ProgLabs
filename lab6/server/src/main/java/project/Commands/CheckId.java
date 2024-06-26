package project.Commands;

import project.Collections.Movie;
import project.Managers.CollectionManager;

import java.io.IOException;

public class CheckId extends AbstractCommand{

    
    public CheckId(String name, String description) {
        super(name, description);
    }

    @Override
    public String execute(String args, Object object) throws IOException {
        CollectionManager collectionManager  =  CollectionManager.getInstance();
        Movie mov = collectionManager.getMovieByid(args);
        if (mov != null){
            return "true";
        }
        else {;
            return "false";
        }
    }
}
