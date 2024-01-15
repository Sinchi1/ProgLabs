package src.Bin;

import java.util.ArrayList;

import src.AbstractClasses.Character;
import src.Enums.Places;
import src.Interfaces.BecameAble;
import src.Interfaces.HumanAble;

public class Human extends Character implements HumanAble , BecameAble {

    private String name;

    private static ArrayList<Human> Humans = new ArrayList<Human>();

    

    public  Human(String name){
    Humans.add(this);
    this.name = name; 
    System.out.println("Создан персонаж " + name + "!");
}

    public static int HumanCount(){
        int result = Humans.size();
        return result;
    }


    public String getName() {
    return name;
    }

    public static ArrayList<Human> getNameall(){
        return Humans;
    }

    @Override
    public void speak(Human insertName1) {
        String name4;
        name4 = insertName1.getName();
        System.out.println(name + " said smth to " + name4 + ".");
        
    }
    @Override
    public void getOff(Human insertName,Places insertPlace) { // местоимени можно сделать класс
        String name3;
        String PlaceName = "";
        switch (insertPlace) {
                case nose -> PlaceName = Places.nose.getName();
    
                case ship -> PlaceName = Places.ship.getName();
    
                case island -> PlaceName = Places.island.getName();

                case horizont -> PlaceName = Places.horizont.getName();

                    
            }
        name3 = insertName.getName();
        System.out.print(name3+" слез c "+ PlaceName);
    }

    @Override
    public void sitNear(Human insertName,Human insertName1){
        //String name3;
        String name4;
        //name3 = insertName.getName();
        name4 = insertName1.getName();
        System.out.print(" и подсел к "+name4 +".");
    }

    @Override
    public void walk() {
        System.out.println(name + "Идёт на двух ногах");;
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

      Human human = (Human) obj;

      return name != null ? name.equals(human.name) : null;

    }

    @Override
    public String toString() {
    return "Character [name=" + name + "]";

}

}
