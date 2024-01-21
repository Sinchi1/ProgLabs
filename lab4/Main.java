
import Exceptions.UnderstandException;
import src.Bin.CandyStore;
import src.Bin.City;
import src.Bin.Dubina;
import src.Bin.Function;
import src.Bin.FunctionHumans;
import src.Bin.Haps;
import src.Bin.Human;
import src.Bin.NewsPaper;
import src.Bin.Place;
import src.Bin.City.Citizen;
import src.Enums.MentalState;
import src.Enums.Times;




public class Main {
    public static void main(String[] args){

        Haps Haps = new Haps();
    
        Human tvWatchers = new Human("Телезрители");
        
        Human korespor1 = new Human("Корреспонденты");

        Human korespor2 = new Human("Корреспондентки");

        Place space = new Place("космос");
        
        Place Door = new Place("дверь");

        Place komnata = new Place("Комната");

        Place nomer = new Place("гостиничная комната");

        Dubina Dubinkas = new Dubina("Дубинками");

        Dubina Dubinka = new Dubina("Дубинок", null,"Электрических");

        Function tvStudia = new Function("Телестудия");

        Function Police = new Function("Полиция");

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

        Citizen inner = davilonCity.new Citizen("");

        Haps.understand(true);
        try {
            Haps.understand(false);
        } catch (UnderstandException e) {
        }

        Haps.blink(PoliceMan, Door);

        PoliceMan.workWithTool(Dubinkas);

        tvWatchers.observate();

        korespor1.runAway(korespor2, komnata);

        korespor1.dodgeFromSmth(Dubinka);

        funck.pullOut(komnata);

        teleOper.rollout("телекамера", komnata);

        paper.newsApper(Times.morning, davilonCity, neznaika);

        paper.appearance(neznaika);

        neznaika.photographed(ghostni4a);

        candyStore.soldOutKor();

        davilonCity.citybuzzed(Times.day);

        inner.readNewsPapper(neznaika, paper, Times.morning, true);

        inner.readNewsPapper(neznaika, ghostni4a, space);

        Haps.incomeRise(nomer, 2);

        Haps.sane(neznaika, MentalState.mad, MentalState.normal);

        Haps.dontAgreeToShow(neznaika);

        tvWatchers.callAngry(Vladelec);


        



        



       

        

        
    }    
}
