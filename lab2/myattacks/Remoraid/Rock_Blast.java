package myattacks.Remoraid;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Rock_Blast extends PhysicalMove{
   public Rock_Blast(double pow,double acc){
    super(Type.ROCK, pow, acc); //25 90
   }
   @Override
   protected void applyOppDamage(Pokemon p, double power){
    if (bin.Main.Calcchance(3d, 8d)){
        super.applyOppDamage(p, 50d);
        super.applyOppDamage(p, 75d);
    }
    else if (bin.Main.Calcchance(1d, 8d)){
        super.applyOppDamage(p, 100);
        super.applyOppDamage(p, 125);
    }
}
    public static boolean chanceHit(Double d,double b){
        return d/b > Math.random();
        
    }
       @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }
}
