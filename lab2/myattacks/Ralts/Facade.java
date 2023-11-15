package myattacks.Ralts;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Facade extends PhysicalMove {
   public Facade(double pow,double acc){
    super(Type.NORMAL, pow, acc);//70 100
   }
   @Override
   protected void applyOppDamage(Pokemon p, double power){
      if (p.getCondition().toString().equals("PARALYZE")){
         super.applyOppDamage(p, power*2);
         System.out.println("Ralts нанёс двойной урон!");
      }
      if (p.getCondition().toString().equals("BURN")){
         super.applyOppDamage(p, power*2);
         System.out.println("Ralts нанёс двойной урон!");
      }
      if (p.getCondition().toString().equals("POISONED")){
         super.applyOppDamage(p, power*2);
         System.out.println("Ralts нанёс двойной урон!");
      }
   }

   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }

    
}
    

