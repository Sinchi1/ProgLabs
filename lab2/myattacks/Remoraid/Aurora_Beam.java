package myattacks.Remoraid;

import bin.Main;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Aurora_Beam extends SpecialMove {
   public Aurora_Beam(double pow,double acc){
    super(Type.ICE, pow, acc); //65 100
   }
   @Override
   protected void applyOppEffects(Pokemon p){
      super.applyOppEffects(p);
      if (Main.chance(0.1)){
         Effect effect = new Effect().stat(Stat.ATTACK,-1);
         p.addEffect(effect);
         System.out.println("Remoraid успешно понизил атаку" + " " + p.toString());
      }
   }

   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }

        

    
}
