import java.io.Serializable;
import java.util.*;

/**
 * The Player class handles all the classes that are related to a player board
 * and implements player's decisions.
 */
public class Player implements Serializable {
    /*Nickname of the player*/
    private final String name;
    /*Points gathered by the player*/
    private int points;
    /*Wall containing the progress of the player*/
    public Wall wall;
    /*Pattern lines filled by the player*/
    public PatternLines pattern;
    /*Indicator of possession of First Player Tile*/
    private boolean first;
    /*List containing the current state of player's floor line*/
    public ArrayList<Tile> floor;


    /**
     * Default constructor
     */
    public Player(String name) {
        this.name = name;
        floor = new ArrayList<>();
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
     * Method for printing the floor
     */
    public void printFloor() {
        System.out.print("Floor:");
        for (int i = 0; i < floor.size(); i++){
            System.out.print(floor.get(i) + " ");
        }
        System.out.println();
    }

}