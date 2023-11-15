package myattacks.Remoraid;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import bin.Main;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Type;

public class Fire_Blast extends SpecialMove {
   public Fire_Blast(double pow,double acc){
    super(Type.FIRE, pow, acc); //110 85
   }

   @Override
   protected void applyOppEffects(Pokemon p){
      super.applyOppEffects(p);
      if (Main.chance(0.1)){
         Effect.burn(p);
      }
   }
   
   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }

    
}
    
    

