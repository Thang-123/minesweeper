//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package controller;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.GameBoard;
import model.GameLevel;
import view.MinesweeperGamePanel;
import view.MinesweeperSelectLevel;

public class MinesweeperController {
    private MinesweeperGamePanel gamePanel;
    private GameBoard gameBoard;
    private boolean gameOver;
    private MinesweeperSelectLevel view;

    public MinesweeperController(MinesweeperGamePanel gamePanel, GameBoard gameBoard, MinesweeperSelectLevel view) {
        this.gamePanel = gamePanel;
        this.gameBoard = gameBoard;
        this.view = view;
        this.gameOver = false;
        this.initializeGamePanel();
        this.showGameWindow();
    }

    private void showGameWindow() {
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(3);
        frame.getContentPane().add(this.gamePanel);
        frame.pack();
        frame.setLocationRelativeTo((Component)null);
        frame.setVisible(true);
    }

    private void initializeGamePanel() {
        JButton[][] buttons = this.gamePanel.getButtons();

        for(int i = 0; i < buttons.length; ++i) {
            for(int j = 0; j < buttons[0].length; ++j) {
                final JButton button = buttons[i][j];
                int finalI = i;
                int finalJ = j;
                button.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent e) {
                        if (!MinesweeperController.this.gameOver) {
                            if (SwingUtilities.isLeftMouseButton(e)) {
                                MinesweeperController.this.revealCell(finalI, finalJ);
                            } else if (SwingUtilities.isRightMouseButton(e)) {
                                MinesweeperController.this.flagCell(button);
                            }
                        }

                    }

                    public void mousePressed(MouseEvent e) {
                    }

                    public void mouseReleased(MouseEvent e) {
                    }

                    public void mouseEntered(MouseEvent e) {
                    }

                    public void mouseExited(MouseEvent e) {
                    }
                });
            }
        }

    }

    private void revealCell(int row, int col) {
        if (this.gameBoard.isMine(row, col)) {
            this.gamePanel.getButtons()[row][col].setText("M");
            JOptionPane.showMessageDialog((Component)null, "Game over! You clicked on a mine.");
            this.revealAllMines();
            this.gameOver = true;
        } else {
            int count = this.gameBoard.getCount(row, col);
            if (count == 0) {
                this.gamePanel.getButtons()[row][col].setEnabled(false);
                this.expandEmptyCells(row, col);
            } else {
                this.gamePanel.getButtons()[row][col].setText(String.valueOf(count));
            }
        }

    }

    private void flagCell(JButton button) {
        if (!button.getText().equals("F")) {
            button.setText("F");
        } else {
            button.setText("");
        }

    }

    private void expandEmptyCells(int row, int col) {
        for(int r = Math.max(0, row - 1); r <= Math.min(this.gameBoard.getRows() - 1, row + 1); ++r) {
            for(int c = Math.max(0, col - 1); c <= Math.min(this.gameBoard.getCols() - 1, col + 1); ++c) {
                if (this.gameBoard.getCount(r, c) == 0 && this.gamePanel.getButtons()[r][c].isEnabled()) {
                    this.gamePanel.getButtons()[r][c].setEnabled(false);
                    this.expandEmptyCells(r, c);
                } else if (this.gameBoard.getCount(r, c) != 0) {
                    this.gamePanel.getButtons()[r][c].setText(String.valueOf(this.gameBoard.getCount(r, c)));
                }
            }
        }

    }

    private void revealAllMines() {
        for(int i = 0; i < this.gameBoard.getRows(); ++i) {
            for(int j = 0; j < this.gameBoard.getCols(); ++j) {
                if (this.gameBoard.isMine(i, j)) {
                    this.gamePanel.getButtons()[i][j].setText("M");
                }
            }
        }

    }

    private void showLevelSelectionDialog(GameLevel selectedLevel) {
        String message = "You selected " + String.valueOf(selectedLevel);
        JOptionPane.showMessageDialog(this.view, message);
        GameBoard gameBoard = new GameBoard(selectedLevel.getRows(), selectedLevel.getCols(), selectedLevel.getMines());
        MinesweeperGamePanel gamePanel = new MinesweeperGamePanel(gameBoard);
        new MinesweeperController(gamePanel, gameBoard, this.view);
    }
}
