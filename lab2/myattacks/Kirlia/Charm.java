package myattacks.Kirlia;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Charm extends SpecialMove {
public Charm(double pow,double acc){
    super(Type.FAIRY, pow, acc);
   }
   @Override
   protected void applyOppEffects(Pokemon p){
      super.applyOppEffects(p);
      Effect effect = new Effect().stat(Stat.ATTACK,-2);
      p.addEffect(effect);
      System.out.println("Kirlia уменьшила силу атаки " + p.toString() + " на два!");
        
    }
   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }    
    
}
