package src.Bin;
import src.Enums.Colors;
import src.Interfaces.EverythingAble;

public class Everything  implements EverythingAble{

    private String name = "Всё";

    public Everything(String name){}

    public void became(Everything inputeverything, Colors inputcolour,
     Boat boat, Passengers passengers, Sail sail ){
        String everything = inputeverything.getName();
        String colour1 = "";
        String boat1 = boat.getName();
        String sail1 = sail.getName();
        String passengers1 = passengers.getName();
        switch (inputcolour) {
            case White -> colour1 = Colors.White.getColour();
            case Red -> colour1 = Colors.Red.getColour();
            case Green -> colour1 = Colors.Green.getColour();
            case Yellow -> colour1 = Colors.Yellow.getColour();
            case GoldenYellow -> colour1 = Colors.GoldenYellow.getColour();
            case Blue -> colour1 = Colors.Blue.getColour();
        }
        System.out.print(everything + " стало " + colour1 + " - " + boat1 + ", " + sail1 + ", " + passengers1 + ". ");
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
      if (!(obj instanceof Everything)) return false;

      Everything everyrhing = (Everything) obj;

      return name != null ? name.equals(everyrhing.name) : null;

    }
    @Override
    public String toString() {
    return "Character [name=" + name + "]";
}
    
}
