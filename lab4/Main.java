import src.Exceptions.TryException;
import src.Exceptions.UnderstandException;
import src.Bin.CandyStore;
import src.Bin.City;
import src.Bin.Dubina;
import src.Bin.FunctionHumans;
import src.Bin.Functions;
import src.Bin.Haps;
import src.Bin.Human;
import src.Bin.NewsPaper;
import src.Bin.Place;
import src.Bin.City.Citizen;
import src.Enums.MentalState;
import src.Enums.Times;




public class Main {

    @FunctionalInterface
    public interface SetDots{
        public void setDot();
    }
    public static void main(String[] args){

        SetDots dot = new SetDots() {
            @Override
            public void setDot(){
                System.out.print(".");
            }
        };

        Haps Haps = new Haps();
    
        Human tvWatchers = new Human("Телезрители");
        
        Human miga = new Human("Мига");

        Human korespor1 = new Human("Корреспонденты");

        Human korespor2 = new Human("Корреспондентки");

        Place space = new Place("космос");
        
        Place Door = new Place("дверь");

        Place komnata = new Place("Комната");

        Place nomer = new Place("гостиничная комната");

        Dubina Dubinkas = new Dubina("Дубинками");

        Dubina Dubinka = new Dubina("Дубинок", null,"Электрических");

        Functions tvStudia = new Functions("Телестудия");

        Functions Police = new Functions("Полиция");

        FunctionHumans PoliceMan = new FunctionHumans("Полицейским",Police);

        FunctionHumans Vladelec = new FunctionHumans("Владелец", tvStudia);

        FunctionHumans funck = new FunctionHumans("Сотрудники", tvStudia);

        FunctionHumans teleOper = new FunctionHumans("Телеоператор", tvStudia);

        City davilonCity = new City("Давилон");

        Human neznaika = new Human("Незнайка");

        NewsPaper paper = new NewsPaper("Газете", "о прибытии");

        Place ghostni4a = new Place("Гостиница");

        CandyStore candyStore = new CandyStore("Кондитерский магазин");

        davilonCity.attachToCity(PoliceMan);

        davilonCity.attachToCity(funck);

        davilonCity.attachToCity(teleOper);  

        Citizen inner = davilonCity.new Citizen();

        
        int count = davilonCity.getPopulation();
        

        try{
            davilonCity.getCitizen(count-1);

        }catch (TryException e){
            throw new TryException("Невозможный житель города!");

        }



        try {
            Haps.understand(true); // True/False
        } catch (UnderstandException e) {
            
            System.out.print(e);
            System.out.println(Haps.getName() + " ничего не понял, и ничего не случилось...");
            return;
        }


        Haps.blink(PoliceMan, Door);

        PoliceMan.workWithTool(Dubinkas); 

        dot.setDot();

        tvWatchers.observate();

        korespor1.runAway(korespor2, komnata);

        korespor1.dodgeFromSmth(Dubinka);

        dot.setDot();

        funck.pullOut(komnata);

        dot.setDot();

        teleOper.rollout("телекамера", komnata);

        dot.setDot();

        paper.newsApper(Times.morning, davilonCity, neznaika);

        dot.setDot();

        paper.appearance(neznaika);

        neznaika.photographed(ghostni4a);

        dot.setDot();

        candyStore.soldOutKor();

        dot.setDot();

        davilonCity.citybuzzed(Times.day);

        dot.setDot();

        inner.readNewsPapper(neznaika, paper, Times.morning);

        dot.setDot();

        inner.ComeToVisit(neznaika, ghostni4a, space);

        dot.setDot();

        Haps.incomeRise(nomer, 2);

        dot.setDot();

        Haps.sane(neznaika, MentalState.mad, MentalState.normal);

        dot.setDot();

        Haps.dontAgreeToShow(neznaika);

        tvWatchers.callAngry(Vladelec);

        Vladelec.threatsWorked(miga);

        dot.setDot();


        



        



       

        

        
    }    
}
