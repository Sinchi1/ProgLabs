package src.Bin;

import Exceptions.UnderstandException;
import src.AbstractClasses.Character;
import src.Enums.MentalState;

public class Haps extends Character {

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

    public  void understand(boolean bool){ // Здесь будет первый try catch 
        String humanName = name;
        if (bool == true){
            System.out.print(humanName + " понял что его никто не слушается, ");
        }
        else{
            throw new UnderstandException("Глупышка ничего не поняла");
        }

    }

    public void incomeRise( Place place,int in){
        String humanName = name;
        int intName = in;
        String placeName = place.getName();
        System.out.println("Доходы господина "+humanName+" сразу увеличились в "+intName+" раза, так как он моментально повысил плату за " + placeName);
    }

    public String getName() {
        return name;
    }

    

}
