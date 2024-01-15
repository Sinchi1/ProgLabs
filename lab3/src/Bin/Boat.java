package src.Bin;
import java.util.ArrayList;

import src.AbstractClasses.Transport;



public class Boat extends Transport {

    private int capacity;

    private String name;

    //public String PassengersOfBoat;

    public String PassangerOfBoat;

    private  ArrayList<Passengers> PassengersOfBoat = new ArrayList<Passengers>();
    
    public  int count = 0;

    public void attachPassanger(Passengers pas) {
        PassengersOfBoat.add(pas);
        System.out.println("Всего пассажиров в лодке:" + PassengersOfBoat.size() );
        System.out.println("Мест осталось:" + (capacity - PassengersOfBoat.size()));
    }

    @Override
    public String Checkcapacity(){
     if (capacity > PassengersOfBoat.size()){
        return "Все пассажиры лодки";
        
     }
     else{
        return capacity + " Пассажиров лодки и " + (PassengersOfBoat.size()-capacity)+ 
        "плывущих рядом.";
     }
   }

   public int getcountPassengerOfBoat(){
    return PassengersOfBoat.size();
   }



    public Boat(String name,int capacity){
        this.name = name;
        this.capacity = capacity;
        System.out.println("Создано место" + name + "!");
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
