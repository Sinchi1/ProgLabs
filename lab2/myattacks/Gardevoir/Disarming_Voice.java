package myattacks.Gardevoir;


import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Disarming_Voice extends SpecialMove {
       public Disarming_Voice(double pow,double acc){
    super(Type.FAIRY, pow, acc);
    }
   @Override
   protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " +  piece[piece.length-1];
   }    
}
