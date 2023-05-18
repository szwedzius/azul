import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WallTest {

    @Test
    void addTileTest1() {
        Wall wall1 = new Wall();
        wall1.addTile(Tile.RED, 1);
        assertEquals(true, wall1.containsTile(Tile.RED, 1));

    }

    @Test
    void addTileTest2() {
        Wall wall2 = new Wall();
        wall2.addTile(Tile.BLUE, 3);
        assertEquals(false, wall2.containsTile(Tile.YELLOW, 3));

    }

    @Test
    void colourCheckTest1() {
        Wall wall3 = new Wall();
        wall3.addTile(Tile.WHITE, 4);
        assertEquals(true, wall3.colourCheck(Tile.WHITE, 4));
    }

    @Test
    void colourCheckTest2() {
        Wall wall5 = new Wall();
        wall5.addTile(Tile.WHITE, 4);
        wall5.addTile(Tile.BLUE, 1);
        assertEquals(false, wall5.colourCheck(Tile.BLUE, 4));
    }

    @Test
    void isRowFull1() {
        Wall wall6 = new Wall();
        wall6.addTile(Tile.RED, 3);
        wall6.addTile(Tile.BLUE, 3);
        wall6.addTile(Tile.BLACK, 3);
        wall6.addTile(Tile.WHITE, 3);
        wall6.addTile(Tile.YELLOW, 3);
        assertEquals(true, wall6.IsRowFull(3));
    }

    @Test
    void isRowFull2() {
        Wall wall7 = new Wall();
        wall7.addTile(Tile.RED, 2);
        wall7.addTile(Tile.WHITE, 2);
        wall7.addTile(Tile.BLACK, 2);
        wall7.addTile(Tile.BLUE, 2);
        assertEquals(false, wall7.IsRowFull(3));
    }

    @Test
    void countPointsForTileTest() {
        Wall wall8 = new Wall();
        wall8.addTile(Tile.BLUE, 2);
        wall8.addTile(Tile.YELLOW, 2);
        wall8.addTile(Tile.RED, 2);
        assertEquals(3, wall8.countPointsForTile(2 , 2));
    }

}