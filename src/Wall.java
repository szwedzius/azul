/**
 * Class representing the wall with the pattern present
 * on each player's board
 */
public class Wall {
    /**
     * Matrix indicating which of the places on player's wall are filled
     */
    private final boolean[][] filled;

    /**
     * Matrix of tiles on the wall creating the pattern
     */
    private final Tile[][] pattern;

    /**
     * Default constructor
     */
    public Wall(){
        filled = new boolean[][]{{false, false, false, false, false},
                                 {false, false, false, false, false},
                                 {false, false, false, false, false},
                                 {false, false, false, false, false},
                                 {false, false, false, false, false}};
        pattern = new Tile[][]{{Tile.BLUE, Tile.YELLOW, Tile.RED, Tile.BLACK, Tile.WHITE},
                               {Tile.WHITE, Tile.BLUE, Tile.YELLOW, Tile.RED, Tile.BLACK},
                               {Tile.BLACK, Tile.WHITE, Tile.BLUE, Tile.YELLOW, Tile.RED},
                               {Tile.RED, Tile.BLACK, Tile.WHITE, Tile.BLUE, Tile.YELLOW},
                               {Tile.YELLOW, Tile.RED, Tile.BLACK, Tile.WHITE, Tile.BLUE}};
    }

    /**
     * Placing a tile on the wall
     * @param tile colour of the tile
     * @param row row in which it will be put
     * @return Number of points scored for the tile's placement
     */
    public int addTile(Tile tile, int row) {
        int column = 0;
        for (int i = 0; i < 5; i++){
            if (pattern[row][i] == tile){
                filled[row][i] = true;
                column = i;
                break;
            }
        }
        return countPointsForTile(column, row);
    }

    private int countPointsForTile(int column, int row) {
        int horizontalPoints = 0;
        int verticalPoints = 0;

        // checking horizontally
        for (int i = column - 1; i >= 0; i--){
            if (!filled[row][i])
                break;
            horizontalPoints++;
        }

        for (int i = column + 1; i < 5; i++){
            if (!filled[row][i])
                break;
            horizontalPoints++;
        }

        // checking vertically
        for (int i = column - 1; i >= 0; i--){
            if (!filled[i][column])
                break;
            verticalPoints++;
        }

        for (int i = column + 1; i < 5; i++){
            if (!filled[i][column])
                break;
            verticalPoints++;
        }

        if(verticalPoints == 4)
            verticalPoints += 7;
        if(horizontalPoints == 4)
            verticalPoints += 2;
        if(horizontalPoints > 0)
            horizontalPoints++;
        if(verticalPoints > 0)
            verticalPoints++;
        if(verticalPoints + horizontalPoints == 0)
            verticalPoints++;

        // BLACK, RED, WHITE, YELLOW, BLUE,
        int[] amounts = new int[]{0, 0, 0, 0, 0};
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                amounts[pattern[i][j].ordinal()] += 1;
            }
        }
        for(int i=0; i<5; i++)
            if(amounts[i] == 5)
                horizontalPoints += 10;

        return verticalPoints + horizontalPoints;
    }

    /**
     * Evaluation whether the given colour is already present
     * in the indicated row
     * @param tile indicated colour
     * @param row indicated row, to be checked
     * @return Result of the evaluation
     */
    public boolean colourCheck(Tile tile, int row) {
        for (int i = 0; i < 5; i++) {
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
        return true;
    }

    public boolean containsTile(Tile tile, int row){
        for (int i = 0; i < 5; i++){
            if (filled[row][i] && pattern[row][i] == tile)
                return true;
        }
        return false;
    }
}