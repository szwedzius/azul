import java.util.*;

/**
 * The PatternLines class represents lines that
 * are being filled by the player
 */
public class PatternLines {
    /**
     * Rows of pattern lines
     */
    private final Tile[][] rows = new Tile[5][5];

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
    public void addToRow(int row, Colour colour, int amount) {
        // TODO implement here
    }

    /**
     * Evaluation whether the given row is full
     * @param row given row
     * @return Result of the evaluation
     */
    private boolean isRowFull(int row) {
        return switch (row) {
            case 0 -> rows[row][0] != null;
            case 1 -> (rows[row][0] != null && rows[row][1] != null);
            case 2 -> (rows[row][0] != null && rows[row][1] != null && rows[row][2] != null);
            case 3 -> (rows[row][0] != null && rows[row][1] != null && rows[row][2] != null && rows[row][3] != null);
            case 4 ->
                    (rows[row][0] != null && rows[row][1] != null && rows[row][2] != null && rows[row][3] != null && rows[row][4] != null);
            default -> throw new IllegalArgumentException("The specified row does not exist");
        };
    }

    /**
     * Evaluation whether the given row is full
     * @param row given row
     * @return Result of the evaluation
     */
    public boolean isRowEmpty(int row) {
        return switch (row) {
            case 0 -> rows[row][0] == null;
            case 1 -> (rows[row][0] == null && rows[row][1] == null);
            case 2 -> (rows[row][0] == null && rows[row][1] == null && rows[row][2] == null);
            case 3 -> (rows[row][0] == null && rows[row][1] == null && rows[row][2] == null && rows[row][3] == null);
            case 4 ->
                    (rows[row][0] == null && rows[row][1] == null && rows[row][2] == null && rows[row][3] == null && rows[row][4] == null);
            default -> throw new IllegalArgumentException("The specified row does not exist");
        };
    }

    /**
     * Method that clears the given row
     * @param row given row
     */
    public void clearRow(int row) {
        if (row < 5 && row >= 0){
            for (int i = 0; i <= row; i++){
                rows[row][i] = null;
            }
        }
        else
            throw new IllegalArgumentException("The specified row does not exist");
    }
}