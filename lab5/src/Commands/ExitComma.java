package Commands;

public class ExitComma extends AbstractCommand{
    public ExitComma(String name, String description) {
        super(name, description);
    }

    @Override
    public String execute(String args) {
        System.exit(1);
        return  null;
    }
}