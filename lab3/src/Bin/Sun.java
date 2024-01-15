package src.Bin;
import src.AbstractClasses.Entity;
import src.Enums.Colors;
import src.Enums.Disntance;
import src.Enums.Places;
import src.Enums.Speeds;
import src.Enums.Times;
import src.Interfaces.SunAble;

public class Sun extends Entity implements SunAble {
private String name;

    public Sun(String name){
    // уууууээээ
    this.name = name; 
    System.out.println("Создан объект " + name + "!");
}
    @Override
    public void slope(Speeds insertSpeed, Sun insertSun,Times insertTimes) {
        String SpeedString = "";
        switch (insertSpeed) {
            case slow -> SpeedString = Speeds.slow.getCharacterization();

            case normally -> SpeedString = Speeds.normally.getCharacterization();

            case fast -> SpeedString = Speeds.fast.getCharacterization();
        }
        String smth1;
        String time1 = "";
        smth1 = insertSun.getName();
        switch (insertTimes) {
            case morning -> time1 = Times.morning.getPositon();
            case day -> time1 = Times.day.getPositon();
            case evening -> time1 = Times.evening.getPositon();        
        }
        System.out.print(smth1 + " " + SpeedString + " клонилось к " + time1 + ", ");
    }

    @Override
    public void setColour(Swell insertSwell, Colors insertColour, Colors inserColour2) {
        String swell = insertSwell.getName();
        String colour1 = "";
        switch (insertColour) {
            case White -> colour1 = Colors.White.getColour();
            case Red -> colour1 = Colors.Red.getColour();
            case Green -> colour1 = Colors.Green.getColour();
            case Yellow -> colour1 = Colors.Yellow.getColour();
            case GoldenYellow -> colour1 = Colors.GoldenYellow.getColour();
            case Blue -> colour1 = Colors.Blue.getColour();
        }
        String colour2 = "";
        switch (inserColour2) {
            case White -> colour2 = Colors.White.getColour();
            case Red -> colour2 = Colors.Red.getColour();
            case Green -> colour2 = Colors.Green.getColour();
            case Yellow -> colour2 = Colors.Yellow.getColour();
            case GoldenYellow -> colour2 = Colors.GoldenYellow.getColour();
            case Blue -> colour2 = Colors.Blue.getColour();
        }
        System.out.print("расцвечивая мёртвую " + swell + " " +colour2+" и " + colour1 + ". " );
    }

    @Override
    public void blazed(Times insertTimes,Sun insertSmth,Places insertPlace,Places insertPlace1,Disntance insertDisntance) {
        String dist1 = "";
        switch (insertDisntance) {
            case far -> dist1 = Disntance.far.getdist();
            case near -> dist1 = Disntance.near.getdist();
        }

        String time1 = "";
        switch (insertTimes) {
            case morning -> time1 = Times.morning.getPositon();
            case day -> time1 = Times.day.getPositon();
            case evening -> time1 = Times.evening.getPositon();
        }
        String PlaceName = "";
        switch (insertPlace) {
            case nose -> PlaceName = Places.nose.getName();
            case ship -> PlaceName = Places.ship.getName();
            case island -> PlaceName = Places.island.getName();
            case horizont -> PlaceName = Places.horizont.getName();
        }
        String PlaceName2 = "";
            switch (insertPlace1) {
            case nose -> PlaceName2 = Places.nose.getName();
            case ship -> PlaceName2 = Places.ship.getName();
            case island -> PlaceName2 = Places.island.getName();
            case horizont -> PlaceName2 = Places.horizont.getName();
        }
        System.out.print(dist1+" "+ "на " + PlaceName2 + " Пламенел в лучах " +  time1  +" "+ PlaceName + " ") ;
    }
    // создать сущность закат ок да?

    public String getName() {
        return name;
    }
    @Override
    public boolean letlightthrough() {
        return false;
    }
    @Override
    public boolean emitlight() {
        return true;
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

  Sun sun = (Sun) obj;

  return name != null ? name.equals(sun.name) :  null;

}

@Override
public String toString() {
return "Character [name=" + name + "]";
}

}
