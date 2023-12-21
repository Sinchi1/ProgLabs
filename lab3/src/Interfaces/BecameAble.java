package src.Interfaces;
import src.Bin.Boat;
import src.Bin.Sail;
import src.Enums.Colors;

public interface BecameAble {
    default public void became(Colors inputcolour,Boat boat, Sail sail ){ 
           String colour1 = "";
           String boat1 = boat.getName();
           String sail1 = sail.getName();
           String passengers1 = boat.Checkcapacity();
           switch (inputcolour) {
               case White -> colour1 = Colors.White.getColour();
               case Red -> colour1 = Colors.Red.getColour();
               case Green -> colour1 = Colors.Green.getColour();
               case Yellow -> colour1 = Colors.Yellow.getColour();
               case GoldenYellow -> colour1 = Colors.GoldenYellow.getColour();
               case Blue -> colour1 = Colors.Blue.getColour();
           }
           System.out.print("Cтало " + colour1 + " - " + boat1 + ", " + sail1 + ", " + passengers1 + ". ");
       
    }

}
