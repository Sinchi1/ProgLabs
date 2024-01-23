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

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!(obj instanceof Place)) return false;

      Place human = (Place) obj;

      return name != null ? name.equals(human.name) : null;

    }

    @Override
    public String toString() {
    return "Character [name=" + name + "]";
    }
}

