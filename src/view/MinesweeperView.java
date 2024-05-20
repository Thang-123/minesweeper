//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MinesweeperView extends JFrame {
    private JButton startButton;

    public MinesweeperView() {
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(3);
        this.setSize(400, 200);
        this.setResizable(false);
        this.setLocationRelativeTo((Component)null);
        JPanel mainPanel = new JPanel(new FlowLayout());
        this.startButton = new JButton("Start Game");
        mainPanel.add(this.startButton);
        this.add(mainPanel);
        this.startButton.addActionListener(new StartGameListener());
        this.setVisible(true);
    }

    private class StartGameListener implements ActionListener {
        private StartGameListener() {
        }

        public void actionPerformed(ActionEvent e) {
            MinesweeperView.this.setVisible(false);
            new MinesweeperSelectLevel();
        }
    }
}
