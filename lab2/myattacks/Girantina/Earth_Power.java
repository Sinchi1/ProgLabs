package myattacks.Girantina;

import bin.Main;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;
// super метод вызова инициализации род класса 
public class Earth_Power extends SpecialMove{
   public Earth_Power(double pow,double acc){
    super(Type.GROUND, pow, acc); // 90 100
   }
   @Override
   protected void applyOppEffects(Pokemon p){
      super.applyOppEffects(p);
      if (Main.chance(0.1)){
         Effect effect = new Effect().stat(Stat.DEFENSE,-1);
         p.addEffect(effect);
         System.out.println("Girantina успешно" + " понизил защиту"+ " " + p.toString());
         
      }
   }
   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }    

    
}
