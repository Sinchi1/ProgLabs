package src.Bin;

import java.util.ArrayList;

import src.Enums.Times;
import src.Exceptions.TryException;
import src.Interfaces.Attachtolocality;

public class City implements Attachtolocality {

    private int population;

    private String name;

    private Human mayor;

    private ArrayList<Citizen> populationList = new ArrayList<Citizen>();

    public Citizen getCitizen(int x) throws TryException{
        if (x > populationList.size()){
            throw new TryException("Невозможный житель города!");
        }
        else{
            return populationList.get(x);
        }
    }

    public void attachToCity(Human human){
        String cityName = this.getName();
        String humanName = human.getName();
        Citizen cit = new Citizen(humanName);
        populationList.add(cit);
        population += 1;
        cit.setCityName(cityName);
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

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (!(obj instanceof City)) return false;

      City human = (City) obj;

      return name != null ? name.equals(human.name) : null;

    }

    @Override
    public String toString() {
    return "Character [name=" + name + "]";
    }
    

    public class Citizen{

        private String name;

        private String cityName;

        private int populationcount = getPopulation();

        public void readNewsPapper(Human human, NewsPaper paper, Times time){
            String humanName = human.getName();
            String cityName = populationList.get(populationcount-1).getCityName();
            String paperName = paper.getName();
            String timeName = "";
            switch (time) {
                case morning -> timeName = Times.morning.getTypeString();
                case day -> timeName = Times.day.getTypeString();
                case evening -> timeName = Times.evening.getTypeString();
            }
            System.out.print("Все " + population + " жителя " + cityName + " просыпаясь "+timeName+" сейчас же хватался за "+ paperName+", чтоб поскорей узнать какие-нибудь новости про "+ humanName);
    
        }

        public void ComeToVisit(Human human, Place place, Place place2){
            String humanName = human.getName();
            String placeName = place.getName();
            String placeName2 = place2.getName();
            System.out.print("Многие ходили к "+placeName+" и толклись там по целым дням, в надежде хоть краешком глаза увидеть "+humanName+", прибывшего из " + placeName2 );
    
        }

        public Citizen() {
        }

        public Citizen(String name) {
            this.name = name;
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
          if (!(obj instanceof Citizen)) return false;
    
          Citizen human = (Citizen) obj;
    
          return name != null ? name.equals(human.name) : null;
    
        }
    
        @Override
        public String toString() {
        return "Character [name=" + name + "]";
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCityName() {
            return cityName;
        }
    }
}
