/**
 * Class representing the wall with the pattern present
 * on each player's board
 */
public class Wall {

    /**
     * Default constructor
     */
    public Wall() {
    }

    /**
     * Matrix indicating which of the places on player's wall are filled
     */
    private boolean[][] filled;

    /**
     * Matrix of tiles on the wall creating the pattern
     */
    private Tile[][] pattern;

    /**
     * Placing a tile on the wall
     * @param tile colour of the tile
     * @param row row in which it will be put
     * @return Number of points scored for the tile's placement
     */
    public int addTile(Tile tile, int row) {
        // TODO implement here
        return 0;
    }

    /**
     * Evaluation whether the given colour is already present
     * in the indicated row
     * @param tile indicated colour
     * @param row indicated row, to be checked
     * @return Result of the evaluation
     */
    public boolean colourCheck(Tile tile, int row) {
        // TODO implement here
        return false;
    }

    /**
     * Evaluation whether the row is full
     * @return Result of the evaluation
     */
    public boolean IsRowFull() {
        // TODO implement here
        return false;
    }

}