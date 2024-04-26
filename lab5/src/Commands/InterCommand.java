package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
/**
 * Interface for all Commands
 */
public interface InterCommand {

    public String getDescription();

    public String getName();

    public void execute(String args) throws IOException;
}
