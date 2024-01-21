package src.Bin;

public class Place {

    private String name;

    private String information;

    public Place(String name, String information){
        this.name = name;
        this.information = information;
    }

    public Place(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getInformation() {
        return information;
    }
}

