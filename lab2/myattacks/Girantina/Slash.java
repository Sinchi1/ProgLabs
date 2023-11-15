package myattacks.Girantina;

import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;

public class Slash extends PhysicalMove {
  public Slash(double pow,double acc){
    super(Type.NORMAL, pow, acc);
  }
  @Override
  protected double calcCriticalHit(Pokemon att,Pokemon def){
    return 1d/8d;
  }
   
  @Override
  protected String describe(){
    String[] piece = this.getClass().toString().split("\\.");
    return "does" + " " + piece[piece.length-1];
  }
   
// Добавить шанс крита
}
