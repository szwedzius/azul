/**
 * Class representing the factory, with its
 * storage and methods
 */
public class Factory {

    /**
     * The tiles that the factory contains
     */
    private Tile[] contents; // TODO as suggested by UML, initialize with size 4

    /**
     * Default constructor
     */
    public Factory() {
    }

    /**
     * Standard isEmpty() method
     * @return Information whether it is empty
     */
    public boolean isEmpty() {
        for (Tile tile : contents){
            if (tile != null)
                return false;
        }
        return true;
    }

    /**
     * Method that removes the tiles of chosen colour
     * from the factory
     * @param tile chosen colour
     */
    public void remove(Tile tile) {
        for (int i = 0; i < 5; i++){
            if (contents[i] == tile)
                contents[i] = null;
        }
    }

    /**
     * Returns the contents of the factory
     * @return Array of tiles contained in the factory
     */
    public Tile[] getContents() {
        return contents;
    }

    /**
     * Adding tiles to the factory at the beggining of next tour
     * @param tiles added tiles
     */
    public void addTiles(Tile[] tiles) {
        System.arraycopy(tiles, 0, contents, 0, tiles.length);
    }

}