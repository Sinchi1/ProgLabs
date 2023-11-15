package myattacks.Octillery;
import bin.Main;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Type;

public class Sludge_Bomb extends SpecialMove{
   public Sludge_Bomb(double pow,double acc){
    super(Type.POISON, pow, acc); // 90 100
   }
   @Override
   protected void applyOppEffects(Pokemon p){
      super.applyOppEffects(p);
      if (Main.chance(0.3)){
         Effect.poison(p);
         System.out.println("Octillery успешно отравил" + " " + p.toString());
      }
   }


   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }
}