package Commands;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface InterCommand {

    public String getDescription();

    public String getName();

    public void execute(String args) throws JsonProcessingException;
}
