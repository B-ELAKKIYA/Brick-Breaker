package com.kce.util;

import com.kce.bean.Brick;

public class Board {

    int size = 7;
    public Object[][] grid = new Object[size][size];

    public Board() {
        initialize();
    }

    private void initialize() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (i == 0 || j == 0 || i == size - 1 || j == size - 1)
                    grid[i][j] = "w";
                else
                    grid[i][j] = " ";
            }
        }

        grid[6][1] = "g";
        grid[6][2] = "g";
        grid[6][3] = "o";
        grid[6][4] = "g";
        grid[6][5] = "g";

        grid[2][2] = new Brick(1);
        grid[2][3] = new Brick(1);
        grid[2][4] = new Brick(1);

        grid[3][2] = new Brick(1);
        grid[3][3] = new Brick(1);
        grid[3][4] = new Brick(1);
    }

    public void display() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (grid[i][j] instanceof Brick)
                    System.out.print(((Brick) grid[i][j]).getStrength() + " ");
                else
                    System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}