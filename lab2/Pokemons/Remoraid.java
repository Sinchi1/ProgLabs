package Pokemons;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Remoraid extends Pokemon {
    public Remoraid(String name,int level){
        super(name,level);
        super.setType(Type.WATER);
        super.setStats(35, 65, 35, 65, 35, 65); 
    }

    
}
