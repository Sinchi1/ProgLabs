
import src.Bin.Boat;
import src.Bin.Everything;
import src.Bin.Human;
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
        Human Troll = new Human("Муми-Тролль");

        Human She = new Human("Ней");
        
        Sun Sun = new Sun("Солнышко");

        Swell swell = new Swell("зыбь");
        
        Boat boat = new Boat();

        Passengers passengers = new Passengers();

        Everything everyrhing = new Everything(null);

        Sail sail = new Sail();

        Troll.getOff(Troll, Places.nose); Troll.sitNear(Troll, She); Sun.slope(Speeds.slow, Sun, Times.evening); 
        Sun.setColour(swell, Colors.Green, Colors.GoldenYellow);
        everyrhing.became(everyrhing, Colors.GoldenYellow, boat, passengers, sail);
        Sun.blazed(Times.evening, Sun, Places.island, Places.horizont, Disntance.far);
        

        

        
    }    
}
