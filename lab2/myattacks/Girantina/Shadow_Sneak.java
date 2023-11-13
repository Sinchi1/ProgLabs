package myattacks.Girantina;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class Shadow_Sneak extends PhysicalMove {
    public Shadow_Sneak(double pow,double acc){
    super(Type.GHOST, pow, acc); // 40 100 Как добавить приоритет 
   }

   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " + piece[piece.length-1];
   }
        
}
