import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    Wall wall = new Wall();

    @Test
    void addTileTest1() {
        wall.addTile(Tile.RED, 1);
        assertEquals(true, wall.containsTile(Tile.RED, 1));

    }

    @Test
    void addTileTest2() {
        wall.addTile(Tile.BLUE, 3);
        assertEquals(false, wall.containsTile(Tile.YELLOW, 3));

    }

    @Test
    void colourCheckTest1() {
        wall.addTile(Tile.WHITE, 4);
        assertEquals(true, wall.colourCheck(Tile.WHITE, 4));
    }

    @Test
    void colourCheckTest2() {
        wall.addTile(Tile.WHITE, 4);
        wall.addTile(Tile.BLUE, 1);
        assertEquals(false, wall.colourCheck(Tile.BLUE, 4));
    }

    @Test
    void isRowFull1() {
        wall.addTile(Tile.RED, 3);
        wall.addTile(Tile.BLUE, 3);
        wall.addTile(Tile.BLACK, 3);
        wall.addTile(Tile.WHITE, 3);
        wall.addTile(Tile.YELLOW, 3);
        assertEquals(true, wall.IsRowFull(3));
    }

    @Test
    void isRowFull2() {
        wall.addTile(Tile.RED, 2);
        wall.addTile(Tile.WHITE, 2);
        wall.addTile(Tile.BLACK, 2);
        wall.addTile(Tile.BLUE, 2);
        assertEquals(false, wall.IsRowFull(3));
    }

}