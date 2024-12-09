package org.example;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameController {
    private Board board;
    private MinesweeperUI ui;
    private int tilesClicked = 0;
    private boolean gameOver = false;

    public GameController(Board board, MinesweeperUI ui) {
        this.board = board;
        this.ui = ui;
        initializeGame();
    }

    private void initializeGame() {
        Tile[][] tiles = board.getTiles();
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                Tile tile = tiles[r][c];
                tile.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        tileClick(tile, e);
                    }
                });
                ui.getBoardPanel().add(tile);
            }
        }
        ui.show();
    }

    void tileClick(Tile tile, MouseEvent e) {
        if (gameOver) return;

        if (e.getButton() == MouseEvent.BUTTON1) {
            if(tile.getText().isEmpty()) {
                if (board.getMines().contains(tile)) {
                    revealMines();
                    ui.getTextLabel().setText("Game Over!");
                    gameOver = true;
                } else {
                    revealTile(tile);
                }
            }
        }
        else if (e.getButton() == MouseEvent.BUTTON3) {
            if (tile.getText().equals("🚩")) {
                tile.setText("");
            } else {
                tile.setText("🚩");
            }
        }
    }

    private void revealMines() {
        for (Tile mine : board.getMines()) {
            mine.reveal();
        }
    }

    private void revealTile(Tile tile) {
        if (!tile.isEnabled() || gameOver || tile.getText().equals("🚩")) {
            return;
        }

        tile.setEnabled(false);
        tilesClicked++;

        int row = tile.getRow();
        int col = tile.getCol();
        int adjacentMines = countAdjacentMines(row, col);

        if (adjacentMines > 0) {
            tile.setText(Integer.toString(adjacentMines));
        }
        else {
            tile.setText("");
            revealNeighborTiles(row, col);
        }

        if (tilesClicked == board.getTiles().length * board.getTiles()[0].length - board.getMines().size()) {
            gameOver = true;
            ui.getTextLabel().setText("You win!");
        }
    }

    private int countAdjacentMines(int row, int col) {
        int mineCount = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (row + i >= 0 && row + i < board.getTiles().length && col + j >= 0 && col + j < board.getTiles()[0].length) {
                    if (board.getMines().contains(board.getTiles()[row + i][col + j])) {
                        mineCount++;
                    }
                }
            }
        }
        return mineCount;
    }

    private void revealNeighborTiles(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (row + i >= 0 && row + i < board.getTiles().length && col + j >= 0 && col + j < board.getTiles()[0].length) {
                    Tile neighborTile = board.getTiles()[row + i][col + j];
                    if (neighborTile.isEnabled()) {
                        revealTile(neighborTile);
                    }
                }
            }
        }
    }
}