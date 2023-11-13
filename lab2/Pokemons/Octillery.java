package Pokemons;
import ru.ifmo.se.pokemon.*;



public class Octillery extends Pokemon{
    public Octillery(String name, int level){
        super(name,level);
        super.setType(Type.WATER);
        super.setStats(75, 105, 75, 105, 75, 45);
    }
    
}
