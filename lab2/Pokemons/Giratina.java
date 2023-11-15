package Pokemons;
import myattacks.Girantina.*;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class  Giratina extends Pokemon {
    public Giratina(String name,int level){
        super(name,level);
        super.setType(Type.FIGHTING,Type.GHOST);
        super.setStats(150, 100, 120, 100, 120, 90);
        Slash slash = new Slash(75, 100);
        Shadow_Sneak shadow_Sneak = new Shadow_Sneak(40, 100);
        ThunderBolt thunderBolt = new ThunderBolt(90, 100);
        Earth_Power earth_Power = new Earth_Power(90, 100);
        super.setMove(slash,shadow_Sneak,thunderBolt,earth_Power);
    }

    
}


