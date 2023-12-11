package src.Bin;
import src.AbstractClasses.Entity;

public class Boat extends Entity {
    
    private String name;

    public Boat(String name){
        this.name = name;
    }

    public Boat(){
        name = "Лодка";
    }
    
    public String getName() {
        return name;
    }

    @Override
    public void letlightthrough() {
        System.out.println("Не пропускает света");
    }

    @Override
    public void emitlight() {
        System.out.println("Не испускает свет");
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

      Boat boat = (Boat) obj;

      return name != null ? name.equals(boat.name) : null;

    }
    
    @Override
    public String toString() {
    return "Character [name=" + name + "]";
}

   
}
