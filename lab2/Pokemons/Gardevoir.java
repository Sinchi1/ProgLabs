package Pokemons;

import myattacks.Gardevoir.Disarming_Voice;
import myattacks.Kirlia.Charm;
import myattacks.Ralts.Facade;
import myattacks.Ralts.Thunder_Wave;
import ru.ifmo.se.pokemon.Type;

public class Gardevoir extends Kirlia {
    public Gardevoir(String name,int level){
        super(name,level);
        super.setType(Type.PSYCHIC,Type.FAIRY);
        super.setStats(68, 65, 65, 125, 115, 80);
        Facade facade = new Facade(70,100);
        Thunder_Wave thunder_Wave = new Thunder_Wave(0,90);   
        Charm charm = new Charm(0, 100);
        Disarming_Voice disarming_Voice = new Disarming_Voice(40, 100);
        super.setMove(facade,thunder_Wave,charm,disarming_Voice);        
    }
    
}
