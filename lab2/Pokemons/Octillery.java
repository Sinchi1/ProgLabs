package Pokemons;
import myattacks.Octillery.Sludge_Bomb;
import myattacks.Remoraid.Aurora_Beam;
import myattacks.Remoraid.Fire_Blast;
import myattacks.Remoraid.Rock_Blast;
import ru.ifmo.se.pokemon.*;



public class Octillery extends Remoraid{
    public Octillery(String name, int level){
        super(name,level);
        super.setType(Type.WATER);
        super.setStats(75, 105, 75, 105, 75, 45);
        Fire_Blast fire_Blast = new Fire_Blast(110, 85);
        Rock_Blast rock_Blast = new Rock_Blast(25, 90);
        Aurora_Beam aurora_Beam = new Aurora_Beam(65,100); 
        Sludge_Bomb sludge_Bomb = new Sludge_Bomb(90, 100);
        super.setMove(fire_Blast,rock_Blast,aurora_Beam,sludge_Bomb);
    }
    
}
