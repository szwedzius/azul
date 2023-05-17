import java.io.BufferedReader;
import java.util.*;

/**
 * The game class handles all other classes
 * and operates on their objects
 */
public class Game {
    /**
     * Number of players playing
     */
    public final int players;

    /**
     * Game mode
     * 1 - singleplayer
     * 0 - multiplayer
     */
    public final int mode;

    /**
     * Table - one instance per game
     */
    public final Table table;

    /**
     * Player class instances - each player is represented by one
     */
    public final Player[] playersTables;

    /**
     * Default constructor
     */
    public Game(int numberOfPlayers, int mode) {
        playersTables = new Player[numberOfPlayers];
        players = numberOfPlayers;
        table = new Table(players);
        this.mode = mode;
    }

    /**
     * Checking whether the conditions for ending the game are met
     * @return Check result
     */
    public boolean isFinished() {
        // TODO implement here
        return false;
    }

    /**
     * Method responsible for saving the current game
     */
    public void save() {
        // TODO implement here
    }

    /**
     * Method responsible for loading the game
     */
    public void load() {
        // TODO implement here
    }

    /**
     * Method for pointing out the winner
     * @return The player who has won
     */
    public Player returnWinner() {
        // TODO implement here
        return null;
    }

    /**
     * Method for getting the number of players
     * @return Number of players
     */
    public int getNumberOfPlayers() {
        return players;
    }

    /**
     * Method to return the table of players
     * @return Table of Player objects representing the players
     */
    public Player[] getPlayersTables() {
        return playersTables;
    }

    public void applyMove(Move move) {
        // TODO
    }
    public static void main(String[] args){

        int numberOfPlayers = 4;

        int mode = 0;
        boolean isEnd = true;
        Tile tile = Tile.BLACK;

        // setup Table and factories
        Game game = new Game(numberOfPlayers, mode);
        for (int i = 0; i < numberOfPlayers; i++){
            String playerName = "XD";
            game.playersTables[i] = new Player(playerName);
        }

        // Printing all factories
        int counter = 0;
        while (isEnd){
            int amount = 0;
            for (int i = 0; i < 2 * numberOfPlayers + 1; i++) {
                Tile[] contents = game.table.factories[i].getContents();
                System.out.print((i + 1) + " Factory : ");
                for (int j = 0; j < 4; j++) {
                    System.out.print(contents[j] + " ");
                }
                System.out.println();
            }

        // Choosing tile from factory
            Scanner reader = new Scanner(System.in);
            String tiles = reader.nextLine();
            int number = reader.nextInt() - 1;
            Tile tileToAdd = switch (tiles.toUpperCase()) {
                case "BLACK" -> Tile.BLACK;
                case "WHITE" -> Tile.WHITE;
                case "BLUE" -> Tile.BLUE;
                case "YELLOW" -> Tile.YELLOW;
                case "RED" -> Tile.RED;
                default -> null;
            };

        // Counting number of tile in factory
            for(int i = 0; i < 4; i++){
                if (game.table.factories[number].getContents()[i] == tileToAdd)
                    amount++;
            }

        // Getting tile from factory
            game.playersTables[0].pattern.addToRow(4, tileToAdd,amount);
            game.table.factories[number].remove(tileToAdd);

            for (int i = 0; i < 4; i++){
                if (game.table.factories[number].getContents()[i] != null){
                    game.table.center.add(game.table.factories[number].getContents()[i]);
                    game.table.factories[number].getContents()[i] = null;
                }

            }

            counter++;
            if (counter == 2)
                isEnd = false;
        }


    }
}