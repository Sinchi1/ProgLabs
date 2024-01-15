package src.Bin;

import java.util.ArrayList;

public class Passengers extends Human {

    public String name;

    public Boat boat;

    //private static int count = getPassengersCount();

    private static ArrayList<Passengers> Passenger = new ArrayList<Passengers>();

    public static int getPassengersCount(){
        int result = Passenger.size();
        return result;
    }

    public Passengers(String name) {
        super(name);
        Passenger.add(this);
        
    }


    @Override
    public int hashCode(){
        int result = super.hashCode();
        result = 31 * result + ((name != null) ? name.hashCode() :0);
        return result;
    }
    @Override
    public String toString(){
    return "Название лодки " + name; 
    }
    @Override
    public boolean equals(Object obj){
    if (this == obj) return true;
    if (!(obj instanceof Passengers)) return false;

    Passengers boat = (Passengers) obj;

    return (name != null)? name.equals(boat.name) : false;
    }
}
