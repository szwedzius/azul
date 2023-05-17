
/**
 * The PatternLines class represents lines that
 * are being filled by the player
 */
public class PatternLines {
    /**
     * Rows of pattern lines
     */
    public final Tile[] colours;
    public final int[] amounts;
    /**
     * Default constructor
     */
    public PatternLines() {
        colours = new Tile[5];
        amounts = new int[]{0, 0, 0, 0, 0};
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
        if (amount < 0 || (amount + amounts[row]) > (row + 1) )
            throw new IllegalArgumentException("The amount of tiles can't be fewer than 0 or higher than the index of row we want to add tiles to");
        if (colours[row] != colour && colours[row] != null)
            throw new IllegalArgumentException("Wrong colour");
        amounts[row] += amount;
    }

    /**
     * Evaluation whether the given row is full
     * @param row given row
     * @return Result of the evaluation
     */
    public boolean isRowFull(int row) {
        if (row > 5 || row < 0)
            throw new IllegalArgumentException("The specified row does not exist");
        return amounts[row] == (row + 1);
    }

    /**
     * Evaluation whether the given row is empty
     * @param row given row
     * @return Result of the evaluation
     */
    public boolean isRowEmpty(int row) {
        if (row > 5 || row < 0)
            throw new IllegalArgumentException("The specified row does not exist");
        return amounts[row] == 0;
    }

    /**
     * Method that clears the given row
     * @param row given row
     */
    public void clearRow(int row) {
        if (row > 5 || row < 0)
            throw new IllegalArgumentException("The specified row does not exist");
        amounts[row] = 0;
        colours[row] = null;
    }
}