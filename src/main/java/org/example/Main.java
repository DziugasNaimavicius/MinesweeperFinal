package org.example;

public class Main {
    public static void main(String[] args) {
        int tileSize = 60;
        int numRows = 9;
        int numCols = 9;
        int mineCount = 10;
        int boardWidth = numCols * tileSize;
        int boardHeight = numRows * tileSize;

        Board board = new Board(numRows, numCols, mineCount);
        MinesweeperUI ui = new MinesweeperUI(boardWidth, boardHeight, numRows, numCols);
        new GameController(board, ui);
    }
}