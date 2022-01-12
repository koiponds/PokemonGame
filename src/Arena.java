import java.util.*;
import java.util.concurrent.TimeUnit;

public class Arena {
    public static int playerPokemon = 0;
    public static int compPokemon = 0;
    public static boolean gameStart = false;

    public static void startGame(Pokemon[] playerArray, Pokemon[] compArray) throws InterruptedException {
        while (!gameStart) {
            System.out.println("Enter any key to Start ");
            TextIO.getlnString();
            gameStart = true;
        }
        while (gameStart) {
            Pokemon player = playerArray[playerPokemon];
            Pokemon comp = compArray[compPokemon];
            comp.statusDamage();
            if (deathCheck(playerArray, compArray)) {
                continue;
            }
            player.statusDamage();
            if (player.getSPD() >= comp.getSPD()) {
                Thread.sleep(1000);
                playerTurn(player, comp);
                if (deathCheck(playerArray, compArray)) {
                    continue;
                }

                System.out.println();

                Thread.sleep(1000);
                compTurn(comp, player);
                if (deathCheck(playerArray, compArray)) {
                    continue;
                }

                System.out.println();
            } else {
                Thread.sleep(1000);
                compTurn(comp, player);
                if (deathCheck(playerArray, compArray)) {
                    continue;
                }

                System.out.println();

                Thread.sleep(1000);
                playerTurn(player, comp);
                if (deathCheck(playerArray, compArray)) {
                    continue;
                }

                System.out.println();
            }
            Thread.sleep(2500);
        }
    }

    private static void playerTurn(Pokemon player, Pokemon comp) throws InterruptedException {
        if (player.getCanMove() == false) {
            System.out.println(player.getName() + " can't move.");
            player.setCanMove(true);
        } else {
            attackChoices(player, comp);
            Thread.sleep(1000);
            System.out.println("Your " + player.getName() + " has " + player.getHP() + " HP remaining");
            Thread.sleep(1000);
            System.out.println("Cynthia's " + comp.getName() + " has " + comp.getHP() + " HP remaining.");
        }
    }
    private static void compTurn (Pokemon comp, Pokemon player) throws InterruptedException {
        if (comp.getCanMove() == false) {
            System.out.println(comp.getName() + " can't move.");
            comp.setCanMove(true);
        } else {
            Random rand = new Random();
            attack(comp, player, rand.nextInt(4));
            Thread.sleep(1000);
            System.out.println("Your " + player.getName() + " has " + player.getHP() + " HP remaining");
            Thread.sleep(1000);
            System.out.println("Cynthia's " + comp.getName() + " has " + comp.getHP() + " HP remaining.");
        }
    }

    private static void attackChoices(Pokemon player, Pokemon comp) throws InterruptedException {
        System.out.println("Possible Moves: "   + "[1] "  + (String) player.getMoveSetArray()[0][0] + "  "
                                                + "[2] "  + (String) player.getMoveSetArray()[1][0] + "  "
                                                + "[3] "  + (String) player.getMoveSetArray()[2][0] + "  "
                                                + "[4] "  + (String) player.getMoveSetArray()[3][0]);
        int attackChoice = TextIO.getlnInt() - 1;
        while (attackChoice > 3 || attackChoice < 0) {
            System.out.println("Please choose a number between 1 and 4. ");
            attackChoice = TextIO.getlnInt() - 1;
            System.out.println();
        }
        attack(player, comp, attackChoice);
    }
    private static void attack(Pokemon player, Pokemon opponent, int attackChoice) throws InterruptedException {
        player.attackString(
                player,
                (String) player.getMoveSetArray()[attackChoice][0],             // Name
                (Types.type) player.getMoveSetArray()[attackChoice][1],         // Type
                (Types.attackType) player.getMoveSetArray()[attackChoice][2],   // Category
                (int) player.getMoveSetArray()[attackChoice][3],                // Power
                (int) player.getMoveSetArray()[attackChoice][4],                // Helaing Power
                (int) player.getMoveSetArray()[attackChoice][5],                // Accuracy
                (Types.status) player.getMoveSetArray()[attackChoice][6],       // Status Effect
                (int) player.getMoveSetArray()[attackChoice][7],                // Status Chance
                (String) player.getMoveSetArray()[attackChoice][8],             // Status Target
                opponent);
    }

    private static boolean deathCheck(Pokemon[] playerArray, Pokemon[] compArray) throws InterruptedException {
        if (playerPokemon == playerArray.length - 1 && playerArray[playerPokemon].getHP() == 0) {
            System.out.println("You have no more available Pokemon");
            System.out.println("You Lose");
            gameStart = false;
            return true;
        }

        if (compPokemon == compArray.length - 1 && compArray[compPokemon].getHP() == 0) {
            System.out.println("Cynthia has no more available Pokemon");
            System.out.println("You Win");
            gameStart = false;
            return true;
        }
        if (playerArray[playerPokemon].getHP() == 0) {
            System.out.println();
            System.out.println(playerArray[playerPokemon].getName() + " has fainted!");
            playerPokemon++;
            Thread.sleep(1000);
            System.out.println(playerArray[playerPokemon].getName() + " has been summoned!");
            System.out.println();
            return true;
        }
        if (compArray[compPokemon].getHP() == 0) {
            System.out.println();
            System.out.println(compArray[compPokemon].getName() + " has fainted!");
            compPokemon++;
            Thread.sleep(1000);
            System.out.println(compArray[compPokemon].getName() + " has been summoned!");
            System.out.println();
            return true;
        }
        return false;
    }
}
