package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testNumberOfMines() {
        int numRows = 5;
        int numCols = 5;
        int mineCount = 5;
        Board board = new Board(numRows, numCols, mineCount);

        assertEquals(mineCount, board.getMines().size(), "Number of board mines should equal mine count");
    }
}
