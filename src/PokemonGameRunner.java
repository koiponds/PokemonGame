public class PokemonGameRunner{
    public static void main (String[] args) throws InterruptedException {
        Pokemon[] playerPokemon = new Pokemon[]{new Empoleon(), new Turtwig(), new Charizard()};
        Pokemon[] compPokemon = new Pokemon[]{new Togekiss(), new Milotic(), new Garchomp()};

        Arena.startGame(playerPokemon,compPokemon);
    }
}
