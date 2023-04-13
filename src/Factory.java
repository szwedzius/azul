
import java.util.*;
/**
 * Class representing the factory, with its
 * storage and methods
 */
public class Factory {

    /**
     * Default constructor
     */
    public Factory() {
    }

    /**
     * The tiles that the factory contains
     */
    private Tile[] contents; // TODO as suggested by UML, initialize with size 4

    /**
     * Standard isEmpty() method
     * @return Information whether it is empty
     */
    public boolean isEmpty() {
        // TODO implement here
        return false;
    }

    /**
     * Method that removes the tiles of chosen colour
     * from the factory
     * @param colour
     */
    public void remove(Colour colour) {
        // TODO implement here
    }

    /**
     * Returns the contents of the factory
     * @return Array of tiles contained in the factory
     */
    public Tile[] getContents() {
        // TODO implement here
        return null;
    }

    /**
     * Adding tiles to the factory at the beggining of next tour
     * @param tiles
     */
    public void addTiles(Tile[] tiles) {
        // TODO implement here
    }

}