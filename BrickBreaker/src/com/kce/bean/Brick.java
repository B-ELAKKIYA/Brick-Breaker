package com.kce.bean;

public class Brick {

    private int strength;

    public Brick(int strength) {
        this.strength = strength;
    }

    public void hit() {
        strength--;
    }

    public boolean isDestroyed() {
        return strength <= 0;
    }

    public int getStrength() {
        return strength;
    }
}