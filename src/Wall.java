/**
 * Class representing the wall with the pattern present
 * on each player's board
 */
public class Wall {

    /**
     * Default constructor
     */
    public Wall(){
    }

    /**
     * Matrix indicating which of the places on player's wall are filled
     */
    private boolean[][] filled;

    /**
     * Matrix of tiles on the wall creating the pattern
     */
    private final Tile[][] pattern = {{Tile.BLUE, Tile.YELLOW, Tile.RED, Tile.BLACK, Tile.WHITE},
                                     {Tile.WHITE, Tile.BLUE, Tile.YELLOW, Tile.RED, Tile.BLACK},
                                     {Tile.BLACK, Tile.WHITE, Tile.BLUE, Tile.YELLOW, Tile.RED},
                                     {Tile.RED, Tile.BLACK, Tile.WHITE, Tile.BLUE, Tile.YELLOW},
                                     {Tile.YELLOW, Tile.RED, Tile.BLACK, Tile.WHITE, Tile.BLUE}};

    /**
     * Placing a tile on the wall
     * @param tile colour of the tile
     * @param row row in which it will be put
     * @return Number of points scored for the tile's placement
     */
    public int addTile(Tile tile, int row) {
        int whereTileIsAdded = 0;
        int isAdjacent = 0;
        // adding tile
        for (int i = 0; i < 5; i++){
            if (pattern[row][i] == tile){
                filled[row][i] = true;
                whereTileIsAdded = i;
                break;
            }
        }
        return countFilledTiles(whereTileIsAdded, row);
    }

    private int countFilledTiles(int whereTileIsAdded, int row) {
        int horizontalPoints = 0;
        int verticalPoints = 0;

        // checking horizontally
        for (int i = whereTileIsAdded - 1; i >= 0; i--){
            if (!filled[row][i])
                break;
            horizontalPoints++;
        }

        for (int i = whereTileIsAdded + 1; i < 5; i++){
            if (!filled[row][i])
                break;
            horizontalPoints++;
        }

        // checking vertically
        for (int i = whereTileIsAdded - 1; i >= 0; i--){
            if (!filled[i][whereTileIsAdded])
                break;
            verticalPoints++;
        }

        for (int i = whereTileIsAdded + 1; i < 5; i++){
            if (!filled[i][whereTileIsAdded])
                break;
            verticalPoints++;
        }

        // +1 because we skipped one tile
        if (horizontalPoints + verticalPoints > 0)
            return verticalPoints + horizontalPoints + 1;
        else
            return 1;
    }

    /**
     * Evaluation whether the given colour is already present
     * in the indicated row
     * @param tile indicated colour
     * @param row indicated row, to be checked
     * @return Result of the evaluation
     */
    public boolean colourCheck(Tile tile, int row) {
        for (int i = 0; i < 5; i++){
            if (pattern[row][i] == tile && filled[row][i])
                return true;
        }
        return false;
    }

    /**
     * Evaluation whether the row is full
     * @return Result of the evaluation
     */
    public boolean IsRowFull(int row) {
        if (row > 5 || row < 0)
            throw new IllegalArgumentException("The specified row does not exist");
        for (int i = 0; i < 5; i++){
            if (!filled[row][i])
                return false;
        }
        return false;
    }
}