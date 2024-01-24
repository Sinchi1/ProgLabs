package src.Bin;

public class Telephone{
    private String name;

    private String id;

    public void receivecall(Telephone telephone){
        String id = telephone.getId();
        System.out.println("Звонок от номера:"+id);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Telephone(String name, String id) {
        this.name = name;
        this.id = id;
    }
    

}
