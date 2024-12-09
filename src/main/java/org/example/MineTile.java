package org.example;

public class MineTile extends Tile {
    public MineTile(int row, int col) {
        super(row, col);
    }

    @Override
    public void reveal() {
        setText("💣");
    }
}