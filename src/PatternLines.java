import java.util.*;

/**
 * The PatternLines class represents lines that
 * are being filled by the player
 */
public class PatternLines {
    /**
     * Rows of pattern lines
     */
    public final Tile[][] rows = new Tile[5][5];

    /**
     * Default constructor
     */
    public PatternLines() {
    }

    /**
     * Adding given amount of tiles of certain colour to given row of pattern lines
     * @param row given row
     * @param colour colour of tiles
     * @param amount amount of given tiles
     */
    public void addToRow(int row, Tile colour, int amount) {
        if (row > 5 || row < 0)
            throw new IllegalArgumentException("The specified row does not exist");
        for (int i = 0; i <= row && amount != 0; i++){
            rows[row][i] = colour;
            amount--;
        }
    }

    /**
     * Evaluation whether the given row is full
     * @param row given row
     * @return Result of the evaluation
     */
    public boolean isRowFull(int row) {
        if (row > 5 || row < 0)
            throw new IllegalArgumentException("The specified row does not exist");
        for (int i = 0; i <= row; i++){
            if (rows[row][i] == null)
                return false;
        }
        return true;
    }

    /**
     * Evaluation whether the given row is full
     * @param row given row
     * @return Result of the evaluation
     */
    public boolean isRowEmpty(int row) {
        if (row > 5 || row < 0)
            throw new IllegalArgumentException("The specified row does not exist");
        for (int i = 0; i <= row; i++){
            if (rows[row][i] != null)
                return false;
        }
        return true;
    }

    /**
     * Method that clears the given row
     * @param row given row
     */
    public void clearRow(int row) {
        if (row > 5 || row < 0)
            throw new IllegalArgumentException("The specified row does not exist");
        for (int i = 0; i <= row; i++)
                rows[row][i] = null;
    }
}