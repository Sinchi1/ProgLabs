package myattacks.Ralts;

import bin.Main;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Thunder_Wave extends StatusMove {
   public Thunder_Wave(double pow,double acc){
    super(Type.ELECTRIC, pow, acc); //0 90
   }
   @Override
   protected void applyOppEffects(Pokemon p){
      super.applyOppEffects(p);
      Effect.paralyze(p);
      if (Main.chance(0.25d)){
        Effect effect = new Effect().stat(Stat.ATTACK,0);
        p.addEffect(effect);
        System.out.println(p.toString() + " " + " Парализован и не может атаковать!");
        }
    Effect effect2 = new Effect().stat(Stat.SPEED,-5);// Получить половину
    p.addEffect(effect2);

   }
   
   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }

    
}
    
    
