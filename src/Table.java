import java.util.*;

/**
 * Class representing the table, on which the factories,
 * bag and box are located
 */
public class Table {
    /**
     * ArrayList representing the tiles present in the box
     */
    private ArrayList<Tile> box;
    /**
     * ArrayList representing the tiles present in the bag
     */
    private ArrayList<Tile> bag;
    /**
     * ArrayList representing the tiles present in the center
     */
    private ArrayList<Tile> center;

    /**
     * Default constructor
     */
    public Table() {
    }

    /**
     * List of factories
     * 2 players - 5 factories
     * 3 players - 7 factories
     * 4 players - 9 factories
     */
    private Factory[] factories;

    /**
     * Number of factories
     */
    private int factoryNo;

    /**
     * @return Result of the evaluation whether the bag is empty
     */
    private boolean isBagEmpty() {
        // TODO implement here
        return false;
    }

    /**
     * Taking the tiles of chosen colour from the center
     * @param colour
     * @return The tiles taken
     */
    public int getTilesFromCenter(Colour colour) {
        // TODO implement here
        return 0;
    }

    /**
     * Taking the tiles of chosen colour from the factory
     * @param colour chosen colour
     * @param factory the index of the factory int the 'factories' list
     * @return The tiles taken
     */
    public int getTilesFromFactory(Colour colour, int factory) {
        // TODO implement here
        return 0;
    }

    /**
     * Evaluation whether tiles of the given colour are present in the center
     * @param colour chosen colour
     * @return Result of the evaluation
     */
    public boolean isColourInCenter(Colour colour) {
        // TODO implement here
        return false;
    }


    /**
     * Evaluation whether tiles of the given colour are present in the factory
     * @param colour chosen colour
     * @param factory the index of the factory int the 'factories' list
     * @return Result of the evaluation
     */
    public boolean isColourInFactory(Colour colour, int factory) {
        // TODO implement here
        return false;
    }

    /**
     * Transfer the tiles from the box to the bag when the bag is empty
     */
    private void refillBag() {
        // TODO implement here
    }

    /**
     * Transfer of tiles from the bag to the factories - at the beginning of each turn
     */
    public void refillFactories() {
        // TODO implement here
    }

    /**
     * Evaluation whether the priority tile has been drawn
     * @return Result of the evaluation
     */
    public boolean priorityTileDrawn() {
        // TODO implement here
        return false;
    }

    /**
     * Evaluation whether the priority tile is in the center
     * @return Result of the evaluation
     */
    public boolean isPriorityTileInCenter() {
        // TODO implement here
        return false;
    }

    /**
     * Transfer the tiles remaining in the factory to the center
     * after the player has taken tiles from it
     */
    private void addToCenter() {
        // TODO implement here
    }

    /**
     * Transfer the tiles that didn't fit in the player's lines to the box
     * @param tile tile to place in the box
     */
    public void addToBox(Tile tile) {
        // TODO implement here
    }

}