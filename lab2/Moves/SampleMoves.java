package Moves;
import bin.Main;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class SampleMoves extends PhysicalMove{
   public SampleMoves(Type type,double pow,double acc){
    super(Type.NORMAL, pow, acc);
   }
   @Override
   protected void applyOppEffects(Pokemon p){
      super.applyOppEffects(p);
      if (Main.chance(0.1)){
         Effect.paralyze(p);
      }
   }
   /*
   @Override
   protected double calcCriticalhit(Pokemon att, Pokemon def){
      super.calcCriticalHit(att, def);
   }
   */
   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + piece[piece.length-1];
   }

    
}
