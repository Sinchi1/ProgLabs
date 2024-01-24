package src.Bin;

import java.util.ArrayList;

import src.AbstractClasses.Character;
import src.AbstractClasses.Entity;
import src.AbstractClasses.Transport;
import src.Interfaces.HumanAble;

public class Human extends Character implements HumanAble {

    private String name;

    private static ArrayList<Human> Humans = new ArrayList<Human>();

    public  Human(String name){
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


    public void workWithTool(Dubina tool){
        String toolName = tool.getName();
        String humanName = this.getName();
        System.out.print(humanName + " принялись работать своими " + toolName );
    }

    public void observate(){
        String humanName = this.getName();
        System.out.print(humanName + " наблюдали ");
        
    }

    public void runAway(Human human2, Place place){
        String humanName1 = this.getName();
        String humanName2 = human2.getName();
        String placeName = place.getName();
        System.out.print("как " + humanName1 + " и " + humanName2 +" убегали из " + placeName + ", " );
    }

    public void dodgeFromSmth(Dubina dubina){
        String humanName = this.getName();
        String toolName = dubina.getName();
        String toolEffect = dubina.getEffect();
        System.out.print(humanName+" уварачивались от " + toolEffect + " " + toolName );
    }

    public  void pullOut(Place place){
        String humanName = this.getName();
        String placeName = place.getName();
        System.out.print(humanName +  " вытаскивали за "+placeName+" все вещи которые у них были. ");
    }

    public void rollout(String string, Place place){
        String humanName = this.getName();
        String stringName = string;
        String placeName = place.getName();
        System.out.print("Последним из "+placeName+" выкатился "+humanName + " сидя на " + stringName);
    }

    public void threatsWorked(Human human){
        String humanName1 = human.getName();
        String humanName2 = this.getName();
        System.out.print("Эти угрозы подействовали, и "+humanName2+" вынужден был согласиться на те условия, которые предложил "+ humanName1);
    }


    public void photographed(Place place){
        class Car extends Transport {

            private String name;

            public Car(String name){
                this.name = name;
            }


            public String getName() {
                return name;
            }

            @Override
            public String MovementMenthod() {
                return "Едет по земле";


            }
        }
        Car car = new Car("Автомашина");
        name = this.getName();
        String carName = car.getName();
        String placeName = place.getName();
        System.out.print(" " + name + " был сфотографирован в тот момент, когда он вылезал из "+carName+", и в тот момент, когда уже вылез, и в тот момент, когда появился в "+ placeName);
    }

    public void callAngry(FunctionHumans fucn,Telephone telephone){
        String tvwatchers = this.getName();
        String humanName = fucn.getName();
        String funcName = fucn.getFunction();
        String telephoneName = telephone.getName();
        String idName = telephone.getId();
        System.out.print("разозлившиеся "+tvwatchers+" стали звонить "+humanName+ " "+ funcName+" по "+telephoneName +"(по номеру:"+idName+") угрожая прекратить выплату взносов за пользование телевизорами.");
    }

    public void runTo(Human human){
        String name1 = human.getName();
        String name = this.getName();
        System.out.print("В результате все "+name+", которые имели еще достаточно сил, чтобы самостоятельно передвигаться, побежали к "+name1+",");
    }

    public void call(Telephone telephone){
        String telephoneName = telephone.getName();
        String id = telephone.getId();
        System.out.print("принялись звонить ему по "+ telephoneName + " по номеру:" + id);
    }

    public void standInLine(Place place, Place place2){
        String placeName = place.getName();
        String placeName2 = place2.getName();
        String humanName = this.getName();
        System.out.print("У "+placeName2+" выстроилась очередь длиной во всю "+ placeName + " состоящия из " + humanName);
    }
    


// Overrided methods from third lab


    // Important override methods

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!(obj instanceof Human)) return false;

      Human human = (Human) obj;

      return name != null ? name.equals(human.name) : null;

    }

    @Override
    public String toString() {
    return "Character [name=" + name + "]";
    }

    @Override
    public void speak(Human insertName1) {
        String name4;
        name4 = insertName1.getName();
        System.out.println(name + " said smth to " + name4 + ".");
        
    }

    @Override
    public void walk() {
        System.out.println(name + "Идёт на двух ногах");
    }



    

}


