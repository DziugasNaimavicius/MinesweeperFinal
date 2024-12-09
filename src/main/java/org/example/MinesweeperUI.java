package org.example;

import javax.swing.*;
import java.awt.*;

public class MinesweeperUI {
    private JFrame frame;
    private JLabel textLabel;
    private JPanel boardPanel;

    public MinesweeperUI(int boardWidth, int boardHeight, int numRows, int numCols) {
        frame = new JFrame("Minesweeper");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel = new JLabel("Minesweeper", JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        textLabel.setOpaque(true);
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(textLabel, BorderLayout.NORTH);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel = new JPanel(new GridLayout(numRows, numCols));
        frame.add(boardPanel, BorderLayout.CENTER);
    }

    public JLabel getTextLabel() {
        return textLabel;
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public void show() {
        frame.setVisible(true);
    }
}