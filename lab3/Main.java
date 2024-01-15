
import src.Bin.Boat;
import src.Bin.Passengers;
import src.Bin.Sail;
import src.Bin.Sun;
import src.Bin.Swell;
import src.Enums.Colors;
import src.Enums.Disntance;
import src.Enums.Places;
import src.Enums.Speeds;
import src.Enums.Times;


public class Main {
    public static void main(String[] args){
        Passengers Troll = new Passengers("Муми-Тролль");

        Passengers She = new Passengers("Ней");
        
        Sun Sun = new Sun("Солнышко");

        Swell swell = new Swell("зыбь");
        
        Boat boat = new Boat("Лодка",8);

        Sail sail = new Sail();

        boat.attachPassanger(She);

        boat.attachPassanger(Troll);
      
        Troll.getOff(Troll, Places.nose); Troll.sitNear(Troll, She); Sun.slope(Speeds.slow, Sun, Times.evening); 
        Sun.setColour(swell, Colors.Green, Colors.GoldenYellow);
        She.became(Colors.GoldenYellow, boat, sail);
        Sun.blazed(Times.evening, Sun, Places.island, Places.horizont, Disntance.far);
       

        

        
    }    
}
