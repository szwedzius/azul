import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class PatternLinesTest {
    @Test
    void addToRowTest(){
        Tile[] test = new Tile[5];
        test[3] = Tile.BLACK;
        PatternLines patternLines = new PatternLines();
        patternLines.addToRow(3,Tile.BLACK,3);
        assertEquals(patternLines.amounts[3],3);
        assertArrayEquals(patternLines.colours, test);
    }
    @Test
    void addToRowTest2(){
        Tile[] test = new Tile[5];
        test[4] = Tile.WHITE;
        PatternLines patternLines = new PatternLines();
        patternLines.addToRow(4,Tile.WHITE,5);
        assertEquals(patternLines.amounts[4], 5);
        assertArrayEquals(patternLines.colours, test);
    }
    @Test
    void isRowFullTest(){
        PatternLines patternLines = new PatternLines();
        patternLines.addToRow(1,Tile.BLACK,2);
        patternLines.addToRow(3,Tile.WHITE,2);
        assertFalse(patternLines.isRowFull(0));
        assertTrue(patternLines.isRowFull(1));
        assertFalse(patternLines.isRowFull(2));
        assertFalse(patternLines.isRowFull(3));
        assertFalse(patternLines.isRowFull(4));
    }
    @Test
    void isRowFullTest2(){
        PatternLines patternLines = new PatternLines();
        patternLines.addToRow(0, Tile.WHITE,1);
        assertTrue(patternLines.isRowFull(0));
        assertFalse(patternLines.isRowFull(1));
        assertFalse(patternLines.isRowFull(2));
        assertFalse(patternLines.isRowFull(3));
        assertFalse(patternLines.isRowFull(4));
    }

    @Test
    void isRowEmptyTest(){
        PatternLines patternLines = new PatternLines();
        assertTrue(patternLines.isRowEmpty(0));
        assertTrue(patternLines.isRowEmpty(1));
        assertTrue(patternLines.isRowEmpty(2));
        assertTrue(patternLines.isRowEmpty(3));
        assertTrue(patternLines.isRowEmpty(4));
    }

    @Test
    void isRowEmptyTest2(){
        PatternLines patternLines = new PatternLines();
        patternLines.addToRow(1,Tile.BLACK,2);
        patternLines.addToRow(3,Tile.WHITE,2);
        assertTrue(patternLines.isRowEmpty(0));
        assertFalse(patternLines.isRowEmpty(1));
        assertTrue(patternLines.isRowEmpty(2));
        assertFalse(patternLines.isRowEmpty(3));
        assertTrue(patternLines.isRowEmpty(4));
    }

    void clearRow(){
        PatternLines patternLines = new PatternLines();
        patternLines.addToRow(1,Tile.BLACK,2);
        patternLines.addToRow(3,Tile.WHITE,2);
        patternLines.clearRow(1);
        assertTrue(patternLines.isRowEmpty(1));
        assertFalse(patternLines.isRowEmpty(3));
    }

    void clearRow1(){
        PatternLines patternLines = new PatternLines();
        patternLines.addToRow(0,Tile.BLACK,1);
        patternLines.addToRow(1,Tile.WHITE,2);
        patternLines.addToRow(2,Tile.YELLOW,3);
        patternLines.addToRow(3,Tile.RED,4);
        patternLines.addToRow(4,Tile.BLUE,4);

        for (int i = 0; i < 5; i++)
            patternLines.clearRow(i);
        assertTrue(patternLines.isRowEmpty(0));
        assertTrue(patternLines.isRowEmpty(1));
        assertTrue(patternLines.isRowEmpty(2));
        assertTrue(patternLines.isRowEmpty(3));
        assertTrue(patternLines.isRowEmpty(4));
    }
}