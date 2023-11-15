package Pokemons;

import myattacks.Kirlia.Charm;
import myattacks.Ralts.Facade;
import myattacks.Ralts.Thunder_Wave;
import ru.ifmo.se.pokemon.*;

public class Kirlia extends Ralts {
    public Kirlia(String name, int level){
        super(name, level);
        super.setType(Type.PSYCHIC,Type.FAIRY);
        super.setStats(38, 35, 35, 65, 55, 50);
        Facade facade = new Facade(70,100);
        Thunder_Wave thunder_Wave = new Thunder_Wave(0,90);   
        Charm charm = new Charm(0, 100);
        super.setMove(facade,thunder_Wave,charm);
    }
}
