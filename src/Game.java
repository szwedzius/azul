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
}