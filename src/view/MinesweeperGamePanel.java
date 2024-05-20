//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.GameBoard;

public class MinesweeperGamePanel extends JPanel {
    private final JButton[][] buttons;

    public MinesweeperGamePanel(GameBoard gameBoard) {
        int rows = gameBoard.getRows();
        int cols = gameBoard.getCols();
        this.setLayout(new GridLayout(rows, cols));
        this.buttons = new JButton[rows][cols];

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < cols; ++j) {
                this.buttons[i][j] = new JButton();
                this.buttons[i][j].setPreferredSize(new Dimension(30, 30));
                this.add(this.buttons[i][j]);
            }
        }

    }

    public JButton[][] getButtons() {
        return this.buttons;
    }
}
