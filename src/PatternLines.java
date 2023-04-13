
import java.util.*;

/**
 * The PatternLines class represents lines that
 * are being filled by the player
 */
public class PatternLines {

    /**
     * Default constructor
     */
    public PatternLines() {
    }
    /**
     * The first row of pattern lines
     */
    private Tile row1[];

    /**
     * The second row of pattern lines
     */
    private Tile row2[];

    /**
     * The third row of pattern lines
     */
    private Tile row3[];

    /**
     * The fourth row of pattern lines
     */
    private Tile row4[];

    /**
     * The fifth row of pattern lines
     */
    private Tile row5[];

    /**
     * Adding given amount of tiles of certain colour to given row of pattern lines
     * @param row given row
     * @param colour colour of tiles
     * @param amount amount of given tiles
     */
    public void addToRow(int row, Colour colour, int amount) {
        // TODO implement here
    }

    /**
     * Evaluation whether the given row is full
     * @param row given row
     * @return Result of the evaluation
     */
    private boolean isRowFull(int row) {
        // TODO implement here
        return false;
    }

    /**
     * Evaluation whether the given row is full
     * @param row given row
     * @return Result of the evaluation
     */
    public boolean isRowEmpty(int row) {
        // TODO implement here
        return false;
    }

    /**
     * Method that clears the given row
     * @param row given row
     */
    public void clearRow(int row) {
        // TODO implement here
    }

}