//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package main;

import javax.swing.SwingUtilities;
import view.MinesweeperView;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                (new MinesweeperView()).setVisible(true);
            }
        });
    }
}
