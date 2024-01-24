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
import src.Bin.Telephone;
import src.Bin.City.Citizen;
import src.Enums.MentalState;
import src.Enums.Times;

import java.util.Scanner;


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

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        Haps Haps = new Haps();
    
        Human tvWatchers = new Human("Телезрители");
        
        Human miga = new Human("Мига");

        Human sickHuman = new Human("Больные");

        Human korespor1 = new Human("Корреспонденты");

        Telephone telephone = new Telephone("телефон","номер не указан");

        Human korespor2 = new Human("Корреспондентки");

        Place space = new Place("космос");
        
        Place Door = new Place("дверь");

        Place shpicHome = new Place("Дом доктора Шприца");

        Place xolStreat = new Place("Холерную улицу");

        Place komnata = new Place("Комната");

        Place nomer = new Place("гостиничная комната");

        Dubina Dubinkas = new Dubina("Дубинками");

        Dubina Dubinka = new Dubina("Дубинок", "Пластик","Электрических");

        Functions tvStudia = new Functions("Телестудия");

        Functions Police = new Functions("Полиция");

        Functions Medic = new Functions("Больница");

        FunctionHumans doctor = new FunctionHumans("Доктор Шприц", Medic);
    
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
            davilonCity.getCitizen(x);

        }catch (TryException e){
            throw new TryException("Невозможный житель города!");

        }



        try {
            Haps.understand(true);
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

        paper.photoAppear(doctor);

        doctor.inspect(neznaika);

        sickHuman.runTo(doctor);
        
        sickHuman.call(telephone);

        dot.setDot();

        sickHuman.standInLine(xolStreat, shpicHome);

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

        tvWatchers.callAngry(Vladelec,telephone);

        Vladelec.threatsWorked(miga);

        dot.setDot();

        
    }    
}
