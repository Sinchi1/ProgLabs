package myattacks.Girantina;

import bin.Main;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class ThunderBolt extends SpecialMove {
    public ThunderBolt(double pow,double acc){
    super(Type.ELECTRIC, pow, acc); // 90 100
   }
    @Override
    protected void applyOppEffects(Pokemon p){
      super.applyOppEffects(p);
      if (Main.chance(0.1)){
         Effect.paralyze(p);
      }
   }

   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " + piece[piece.length-1];
   }
    
}
