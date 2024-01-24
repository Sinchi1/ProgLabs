package src.Bin;

import java.util.ArrayList;
import src.Interfaces.FunctionHumansAble;

public class FunctionHumans extends Human implements FunctionHumansAble {

    private static ArrayList<FunctionHumans> FunctionHumans = new ArrayList<FunctionHumans>();

    private String name;

    private String function;

    public FunctionHumans(String name, Functions function) {
        super(name);
        this.name = name;
        this.function = function.getName();
        FunctionHumans.add(this);
    }

    public static int getPassengersCount(){
        int result = FunctionHumans.size();
        return result;
    }

    @Override
    public  void pullOut(Place place){
        String humanName = this.getName();
        String functionName = this.getFunction();
        String placeName = place.getName();
        System.out.print(humanName + ' ' + functionName + " вытаскивали за "+placeName+" все вещи которые у них были");
    }

    @Override
    public void rollout(String string, Place place){
        String humanName = this.getName();
        String stringName = string;
        String placeName = place.getName();
        System.out.print("Последним из "+placeName+" выкатился "+humanName + " сидя на " + stringName);
    }

    public void inspect(Human human){
        String doctorName = this.getName();
        String humanName = human.getName();
        System.out.print("когда "+doctorName+" осматривал "+humanName);
    }

    @Override
    public void threatsWorked(Human human){
        String humanName1 = human.getName();
        String humanName2 = this.getName();
        String inf = this.getFunction();
        System.out.print("Эти угрозы подействовали, и "+humanName2+" "+inf+" вынужден был согласиться на те условия, которые предложил "+ humanName1);
    }


    @Override
    public int hashCode(){
        int result = super.hashCode();
        result = 31 * result + ((name != null) ? name.hashCode() :0);
        return result;
    }
    @Override
    public String toString(){
    return "Имя: " + name; 
    }
    @Override
    public boolean equals(Object obj){
    if (this == obj) return true;
    if (!(obj instanceof FunctionHumans)) return false;

    FunctionHumans boat = (FunctionHumans) obj;

    return (name != null)? name.equals(boat.name) : false;
    }

    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public static ArrayList<FunctionHumans> getFunctionHumans() {
        return FunctionHumans;
    }
}
