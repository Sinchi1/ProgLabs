package src.Bin;
import src.AbstractClasses.Transport;



public class Boat extends Transport {

    private int capacity;

    private String name;

    public String PassengersOfBoat;

    @Override
    public String Checkcapacity(){
     if (capacity > Passengers.getCount()){
        return PassengersOfBoat = "Все пассажиры лодки";
        
     }
     else{
        return PassengersOfBoat = capacity + " Пассажиров лодки и " + (Passengers.getCount()-capacity)+ 
        "плывущих рядом.";
     }
   }

   public String getPassengerOfBoat(){
    return PassengersOfBoat;
   }
    

    public Boat(String name,int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public Boat(){
        name = "Лодка";
        capacity = 3;
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

      Boat boat = (Boat) obj;

      return name != null ? name.equals(boat.name) : null;

    }
    
    @Override
    public String toString() {
    return "Character [name=" + name + "]";
}

    @Override
    public void MovementMenthod() {
        System.out.println("Плывёт по воде.");
    }

   
}
