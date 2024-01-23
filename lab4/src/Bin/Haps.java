package src.Bin;

import src.Exceptions.*;
import src.Interfaces.HapsAble;
import src.AbstractClasses.Character;
import src.Enums.MentalState;

public class Haps extends Character implements HapsAble {

    private final String name = "Хапс";

    @Override
    public void walk() {
        System.out.println("Прямая походка");
    }

    public void dontAgreeToShow(Human human){
        String humanName = human.getName();
        class Dog{
            private String race;

            public Dog(String race) {
                this.race = race;
            }

            public String getRace() {
                return race;
            }
            
        }
        Dog pudel = new Dog("Пудель");

        String pudelName = pudel.getRace();

        System.out.print(" и за такую ничтожную сумму "+name+" бы показывать по телевидению не то что "+humanName+", но даже простого "+pudelName + ". ");

    }
    
    public void sane(Human vlad, MentalState state, MentalState state2){
        String vladName = vlad.getName();
        String mentalname = "";
            switch (state) {
            case normal -> mentalname = MentalState.normal.getState();
            case mad -> mentalname = MentalState.mad.getState();
        }
        String mentalname2 = "";
        switch (state2) {
        case normal -> mentalname2 = MentalState.normal.getState();
        case mad -> mentalname2 = MentalState.mad.getState();
    }
        System.out.print(name+" сказал, что "+vladName+", принимает их за"+mentalname+", в то время как они "+mentalname2);
    }

    public void blink( Human policeMan, Place place){
        String policeName = policeMan.getName();
        String placeName = place.getName();
        System.out.print(name + " подмигнул стоящим у " + placeName + " " + policeName + ", ");
    }

    public  void understand(boolean bool) throws UnderstandException{ 
        String humanName = name;
        if (bool == true){
            System.out.print(humanName + " понял что его никто не слушается, ");
        }
        else{
            throw new UnderstandException("");
        }

    }

    public void incomeRise( Place place,int in){
        String humanName = name;
        int intName = in;
        String placeName = place.getName();
        System.out.print("Доходы господина "+humanName+" сразу увеличились в "+intName+" раза, так как он моментально повысил плату за " + placeName);
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
      if (!(obj instanceof Haps)) return false;

      Haps human = (Haps) obj;

      return name != null ? name.equals(human.name) : null;

    }

    @Override
    public String toString() {
    return "Character [name=" + name + "]";
    }

    

}
