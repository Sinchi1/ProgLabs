package src.Bin;

import src.AbstractClasses.Entity;
import src.Enums.Times;

public class NewsPaper {

    private String name;

    private String information;

    public NewsPaper(String name, String information){
        this.name = name;
        this.information = information;
    }

    public void newsApper(Times time, City city, Human human){
        information = this.getInformation();
        name = this.getName();
        String cityname = city.getName();
        String humanName = human.getName();
        String timeName = "";
        switch (time) {
            case morning -> timeName = Times.morning.getTypeString();
            case day -> timeName = Times.day.getTypeString();
            case evening -> timeName = Times.evening.getTypeString();
        }
        System.out.print(". На следующее "+timeName + " во всех " + name + " появилось сообщение "+information+" в " + cityname +" "+ humanName + ". " );
    }

    public void appearance(Human human){
        class Suit extends Entity {
            private String suitName;
        
            public Suit(String suitName){
                this.suitName = suitName;
            }
        
            public String getSuitName() {
                return suitName;
            }

            @Override
            public boolean letlightthrough() {
                return false;
            }

            @Override
            public boolean emitlight() {
                return false;
            }
        }
        Suit suit = new Suit("Скафандр");
        String suitName = suit.getSuitName(); 
        String humanName = human.getName();
        name = this.getName();
        System.out.print("На самых видных местах " + name + " был " + humanName + " в " + suitName);
    }
   
   
    public String getName() {
        return name;
    }

    public String getInformation() {
        return information;
    }

}
