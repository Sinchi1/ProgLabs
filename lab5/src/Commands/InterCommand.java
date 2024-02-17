package Commands;

public interface InterCommand {

    public String getDescription();

    public String getName();

    public String execute(String args);
}
