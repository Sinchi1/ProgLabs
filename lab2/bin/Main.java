package bin;
import Pokemons.*;
import ru.ifmo.se.pokemon.Battle;
import ru.ifmo.se.pokemon.Pokemon;

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
   Giratina giratina = new Giratina("Бобик", 0);
   Pokemon p2 = new Pokemon("Хищник", 1);
   b.addAlly(giratina);
   b.addFoe(p2);
   b.go();
   }
   public static boolean chance(Double d){
      return d> Math.random();
   } 
} 
