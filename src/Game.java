
import java.util.*;

/**
 * The game class handles all other classes
 * and operates on their objects
 */
public class Game {

    /**
     * Default constructor
     */
    public Game() {
    }

    /**
     * Number of players playing
     */
    private int players;

    /**
     * Game mode
     * 1 - singleplayer
     * 0 - multiplayer
     */
    private int mode;

    /**
     * Table - one instance per game
     */
    private Table table;

    /**
     * Player class instances - each player is represented by one
     */
    private Player[] playersTables; //TODO init. with size 'players'

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
        // TODO implement here
        return 0;
    }

    /**
     * Method to return the table of players
     * @return Table of Player objects representing the players
     */
    public Player[] getPlayersTables() {
        // TODO implement here
        return null;
    }

}