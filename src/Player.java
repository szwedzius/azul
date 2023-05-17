import java.util.*;

/**
 * The Player class handles all the classes that are related to a player board
 * and implements player's decisions.
 */
public class Player {
    /*Nickname of the player*/
    private final String name;
    /*Points gathered by the player*/
    private int points;
    /*Wall containing the progress of the player*/
    public Wall wall;
    /*Pattern lines filled by the player*/
    public PatternLines pattern;
    /*Indicator of possesion of First Player Tile*/
    private boolean first;
    /*List containing the current state of player's floor line*/
    public ArrayList<Tile> floor;
    /*List containing tiles that are about to be thrown away after each round*/
    private ArrayList<Tile> rejectedTiles;

    /**
     * Default constructor
     */
    public Player(String name) {
        this.name = name;
        floor = new ArrayList<>();
        rejectedTiles = new ArrayList<>();
        pattern = new PatternLines();
        wall = new Wall();
    }

    /**
     * Method for getting the number of points of the player
     * @return Number of points of the player
     */
    public int getPoints() {
        return points;
    }

    /**
     * Method that adds the given amount of points
     * to player's points
     * @param points Given points
     */
    public void sumPoints(int points) {
        this.points += points;
    }

    /**
     * Method setting the indicator first
     */
    public void setFirst() {
        first = true;
    }

    /**
     * Method for clearing the floor line
     */
    public void clearFloor() {
        floor.clear();
    }

    /**
     * Method for rejecting a tile
     * @param tile Rejected tile
     */
    public void rejectTile(Tile tile) {
        rejectedTiles.add(tile);
    }
    /**
     * Method that rejects unused tiles and erases them
     * by passing to the box
     * @return List of rejected tiles
     */
    public ArrayList<Tile> clearRejectedTiles() {
        ArrayList<Tile> temp;
        temp = rejectedTiles;
        rejectedTiles.clear();
        return temp;
    }

}