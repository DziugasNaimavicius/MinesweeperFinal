package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void testTileConstructor() {
        Tile tile = new MineTile(2, 3);

        assertEquals(2, tile.getRow(), "Row should be 2");
        assertEquals(3, tile.getCol(), "Column should be 3");
    }

    @Test
    void testTileSetText() {
        Tile tile = new MineTile(0, 0);

        assertEquals("", tile.getText(), "Tile should not have text");

        tile.setText("1");

        assertEquals("1", tile.getText(), "Tile's text should be 1");
    }
}
