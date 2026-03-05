package com.kce.bean;

public class Ball {

    public int row;
    public int col;
    private int lives;

    public Ball(int row, int col, int lives) {
        this.row = row;
        this.col = col;
        this.lives = lives;
    }

    public void reduceLife() {
        lives--;
    }

    public int getLives() {
        return lives;
    }
}