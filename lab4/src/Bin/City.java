package src.Bin;

import java.util.ArrayList;

import src.Enums.Times;

public class City {

    private int population;

    private String name;

    private Human mayor;

    private static ArrayList<Citizen> populationList = new ArrayList<Citizen>();

    public void attachToCity(Human human){
        String cityName = this.getName();
        String humanName = human.getName();
        Citizen cit = new Citizen(humanName);
        populationList.add(cit);
        population += 1;
        System.out.println(humanName + " привязан к городу " + cityName +" Текущее население города:" + population);
    }

    public City(String name, int population, Human mayor){
        this.name = name;
        this.population = population;
        this.mayor = mayor;
    }

    public City(String name, int population){
        this.name = name;
    }

    public City(String name){
        this.name = name;
    }


    public void citybuzzed(Times time){
        String name = this.name;
        String timeName = "";
        switch (time) {
            case morning -> timeName = Times.morning.getTypeString();
            case day -> timeName = Times.day.getTypeString();
            case evening -> timeName = Times.evening.getTypeString();
        }
        System.out.print("В этот " + timeName + " " + name + "весь гудел");
    }

    public int getPopulation() {
        return population;
    }

    public String getName() {
        return name;
    }

    public Human getMayor() {
        return mayor;
    }

    public ArrayList<Citizen> getPopulationList() {
        return populationList;
    }

    public class Citizen{

        private String name;

        public void readNewsPapper(Human human, NewsPaper paper, Times time, boolean bool){
            String humanName = human.getName();
            String cityName = this.getName();
            String paperName = paper.getName();
            String timeName = "";
            switch (time) {
                case morning -> timeName = Times.morning.getTypeString();
                case day -> timeName = Times.day.getTypeString();
                case evening -> timeName = Times.evening.getTypeString();
            }
            if (bool == true){
                System.out.println(". Все " + population + " жителя " + cityName + " просыпаясь "+timeName+" сейчас же хватался за "+ paperName+", чтоб поскорей узнать какие-нибудь новости про "+ humanName);
            }
            else{
                System.out.println(". Не каждый житель "+ cityName + "просыпаясь "+timeName+" сейчас же хватался за "+ paperName+", чтоб поскорей узнать какие-нибудь новости про "+ humanName);
            }
    
        }

        public void readNewsPapper(Human human, Place place, Place place2){
            String humanName = human.getName();
            String placeName = place.getName();
            String placeName2 = place2.getName();
            System.out.println("Многие ходили к "+placeName+" и толклись там по целым дням, в надежде хоть краешком глаза увидеть "+humanName+", прибывшего из " + placeName2 + ". ");
    
        }

        public Citizen(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
