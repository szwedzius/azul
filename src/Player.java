
import java.util.*;

/**
 * The Player class handles all the classes that are related to a player board
 * and implements player's decisions.
 */
public class Player {

    /**
     * Default constructor
     */
    public Player() {
    }

    /**
     * Nickname of the player
     */
    private String name;

    /**
     * Points gathered by the player
     */
    private int points;

    /**
     * Wall containing the progress of the player
     */
    private Wall wall;

    /**
     * Pattern lines filled by the player
     */
    private PatternLines pattern;

    /**
     * Indicator of possesion of First Player Tile
     */
    private boolean first;

    /**
     * List containing the current state of player's floor line
     */
    private ArrayList<Tile> floor;

    /**
     * List containing tiles that are about to be thrown away after each round
     */
    private ArrayList<Tile> rejectedTiles;

    /**
     * Method for getting the number of points of the player
     * @return Number of points of the player
     */
    public int getPoints() {
        // TODO implement here
        return 0;
    }

    /**
     * Method that adds the given amount of points
     * to player's points
     * @param points Given points
     */
    public void sumPoints(int points) {
        // TODO implement here
    }

    /**
     * Method setting the indicator first
     */
    public void setFirst() {
        // TODO implement here
    }

    /**
     * Method for clearing the floor line
     */
    public void clearFloor() {
        // TODO implement here
    }

    /**
     * Method for rejecting a tile
     * @param tile Rejected tile
     */
    public void rejectTile(Tile tile) {
        // TODO implement here
    }

    /**
     * Method that rejects unused tiles and erases them
     * by passing to the box
     * @return List of rejected tiles
     */
    public ArrayList<Tile> clearRejectedTiles() {
        // TODO implement here
        return null;
    }

}