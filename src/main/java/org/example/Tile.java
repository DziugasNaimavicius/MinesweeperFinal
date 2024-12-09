package org.example;

import javax.swing.*;
import java.awt.*;

abstract class Tile extends JButton {
    protected int row;
    protected int col;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        setFocusable(false);
        setMargin(new Insets(0, 0, 0, 0));
        setFont(new Font("Arial Unicode MS", Font.PLAIN, 35));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public abstract void reveal();
}