package bin;
import Pokemons.*;
import ru.ifmo.se.pokemon.Battle;
// super метод вызова инициализации род класса 

public class Main {
   /*
    https://pokemondb.net/pokedex/giratina - уник
    https://pokemondb.net/pokedex/remoraid - уник
    https://pokemondb.net/pokedex/octillery - уник
    https://pokemondb.net/pokedex/ralts - 1 этап
    https://pokemondb.net/pokedex/kirlia - 2 этап
    https://pokemondb.net/pokedex/gardevoir - 3 этап
   */
   public static void main(String[] args) {

   Battle b = new Battle();
   Giratina giratina = new Giratina("", 1);
   Remoraid remoraid = new Remoraid("", 1);
   Octillery octillery = new Octillery("", 1);
   Ralts ralts = new Ralts("", 1);
   Gardevoir gardevoir = new Gardevoir("", 1);
   Kirlia kirlia = new Kirlia("",1);
   b.addAlly(giratina);
   b.addFoe(octillery);
   b.addAlly(ralts);
   b.addFoe(remoraid);
   b.addAlly(gardevoir);
   b.addFoe(kirlia);
   b.go();
   }
   public static boolean chance(Double d){
      return d> Math.random();
   
   } 
   public static boolean Calcchance(Double d,double b){
      return d/b> Math.random();
   }
} 
