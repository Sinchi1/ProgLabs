package Pokemons;
import myattacks.Ralts.Facade;
import myattacks.Ralts.Thunder_Wave;
import ru.ifmo.se.pokemon.*; 

public class Ralts extends Pokemon {
    public Ralts(String name, int level){
        super(name, level);
        super.setType(Type.PSYCHIC,Type.FAIRY);
        super.setStats(28, 25, 25, 45, 35, 40);
        Facade facade = new Facade(70,100);
        Thunder_Wave thunder_Wave = new Thunder_Wave(0,90);
        super.setMove(facade,thunder_Wave);
    }
    
}
