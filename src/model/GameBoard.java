//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

import java.util.Random;

public class GameBoard {
    private int rows;
    private int cols;
    private int mines;
    private boolean[][] minesArray;
    private int[][] counts;

    public GameBoard(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.minesArray = new boolean[rows][cols];
        this.counts = new int[rows][cols];
        this.generateMines();
        this.calculateCounts();
    }

    private void generateMines() {
        Random random = new Random();
        int count = 0;

        while(count < this.mines) {
            int x = random.nextInt(this.rows);
            int y = random.nextInt(this.cols);
            if (!this.minesArray[x][y]) {
                this.minesArray[x][y] = true;
                ++count;
            }
        }

    }

    private void calculateCounts() {
        for(int i = 0; i < this.rows; ++i) {
            for(int j = 0; j < this.cols; ++j) {
                if (!this.minesArray[i][j]) {
                    int count = 0;

                    for(int r = Math.max(0, i - 1); r <= Math.min(this.rows - 1, i + 1); ++r) {
                        for(int c = Math.max(0, j - 1); c <= Math.min(this.cols - 1, j + 1); ++c) {
                            if (this.minesArray[r][c]) {
                                ++count;
                            }
                        }
                    }

                    this.counts[i][j] = count;
                }
            }
        }

    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public boolean isMine(int row, int col) {
        return this.minesArray[row][col];
    }

    public int getCount(int row, int col) {
        return this.counts[row][col];
    }
}