package Pokemons;
import myattacks.Remoraid.Aurora_Beam;
import myattacks.Remoraid.Fire_Blast;
import myattacks.Remoraid.Rock_Blast;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Remoraid extends Pokemon {
    public Remoraid(String name,int level){
        super(name,level);
        super.setType(Type.WATER);
        super.setStats(35, 65, 35, 65, 35, 65); 
        Fire_Blast fire_Blast = new Fire_Blast(110, 85);
        Rock_Blast rock_Blast = new Rock_Blast(25, 90);
        Aurora_Beam aurora_Beam = new Aurora_Beam(65,100);
        super.setMove(fire_Blast,rock_Blast,aurora_Beam);
    }

    
}
