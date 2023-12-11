package src.Bin;
import src.AbstractClasses.Character;

public class Passengers extends Character {

    private String name;

    public Passengers(String name){
        this.name = name;
    }

    public Passengers(){
        name = "Пассажиры";
    }
    
    public String getName() {
        return name;
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
      if (!(obj instanceof Boat)) return false;

      Passengers passengers = (Passengers) obj;

      return name != null ? name.equals(passengers.name) : null;

    }

    @Override
    public String toString() {
    return "Character [name=" + name + "]";
}

    @Override
    public void walk() {
        System.out.println("Пассажиры идут");;
    }
}
