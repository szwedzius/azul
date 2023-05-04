import java.util.*;

/**
 * Class representing the tile
 */
public class Tile {
    /**
     * Default constructor
     */
    public Tile(Colour colour) {
        this.colour = colour;
    }

    /**
     * Colour of the tile - from Enum Colour
     */
    private Colour colour;

    /**
     * Standard getter method for the 'colourr' field
     * @return Tile's colour
     */
    public Colour getColour() {
        return colour;
    }

}