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
    public final ArrayList<Tile> center;

    /**
     * List of factories
     * 2 players - 5 factories
     * 3 players - 7 factories
     * 4 players - 9 factories
     */
    public Factory[] factories;

    /**
     * Number of factories
     */
    private final int factoryNo;

    /**
     * Default constructor
     */
    public Table(int numberOfPlayers) {
        factoryNo = numberOfPlayers*2 + 1;
        factories = new Factory[factoryNo];
        for (int i = 0; i < factoryNo; i++)
            factories[i] = new Factory();
        center = new ArrayList<>();
        center.add(Tile.FIRSTTILE);
        bag = new ArrayList<>(100);
        for (int i = 0; i < 20; i++) {
            bag.add(Tile.WHITE);
            bag.add(Tile.BLUE);
            bag.add(Tile.BLACK);
            bag.add(Tile.RED);
            bag.add(Tile.YELLOW);
        }

        box = new ArrayList<>();
        refillFactories();
    }

    /**
     * @return Result of the evaluation whether the bag is empty
     */
    private boolean isBagEmpty() {
        return bag.isEmpty();
    }

    /**
     * Taking the tiles of chosen colour from the center
     * @param tile chosen colour
     * @return The tiles taken
     */
    public int getTilesFromCenter(Tile tile) {
        int temp = 0;
        if (isPriorityTileInCenter())
            center.remove(Tile.FIRSTTILE);
        while (isColourInCenter(tile)) {
            temp++;
            center.remove(tile);
        }
        return temp;
    }

    /**
     * Taking the tiles of chosen colour from the factory
     * @param tile chosen colour
     * @param factoryNumber the index of the factory int the 'factories' list
     * @return The tiles taken
     */
    public int getTilesFromFactory(Tile tile, int factoryNumber) {
        int temp = 0;
        while (isColourInFactory(tile, factoryNumber)) {
            temp++;
            factories[factoryNumber].remove(tile);
        }
        center.addAll(List.of(factories[factoryNumber].getContents()));
        factories[factoryNumber] = new Factory();
        return temp;
    }

    /**
     * Evaluation whether tiles of the given colour are present in the center
     * @param tile chosen colour
     * @return Result of the evaluation
     */
    public boolean isColourInCenter(Tile tile) {
        return center.contains(tile);
    }


    /**
     * Evaluation whether tiles of the given colour are present in the factory
     * @param tile chosen colour
     * @param factory the index of the factory int the 'factories' list
     * @return Result of the evaluation
     */
    public boolean isColourInFactory(Tile tile, int factory) {
        for (int i = 0; i < 4; i++) {
            if(factories[factory].getContents()[i] == tile)
                return true;
        }
        return false;
    }

    /**
     * Transfer the tiles from the box to the bag when the bag is empty
     */
    private void refillBag() throws Exception {
        if(isBagEmpty()) {
            bag = box;
            box = new ArrayList<>();
        } else
            throw new Exception("Can't refill bag until it is not empty");
    }

    /**
     * Transfer of tiles from the bag to the factories - at the beginning of each turn
     */
    public void refillFactories() {
        Random rand = new Random();
        for (int i = 0; i < factoryNo; i++){
            int temp;
            Tile tile1, tile2, tile3, tile4;
            temp = rand.nextInt(bag.size());
            tile1 = bag.get(temp);
            bag.remove(temp);
            temp = rand.nextInt(bag.size());
            tile2 = bag.get(temp);
            bag.remove(temp);
            temp = rand.nextInt(bag.size());
            tile3 = bag.get(temp);
            bag.remove(temp);
            temp = rand.nextInt(bag.size());
            tile4 = bag.get(temp);
            bag.remove(temp);
            Tile[] factoryTiles = new Tile[]{tile1, tile2, tile3, tile4};
            factories[i].addTiles(factoryTiles);
        }
    }

    /**
     * Evaluation whether the priority tile is in the center
     * @return Result of the evaluation
     */
    public boolean isPriorityTileInCenter() {
        return center.contains(Tile.FIRSTTILE);
    }

}