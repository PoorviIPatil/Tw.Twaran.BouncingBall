package com.tw.dojo.bouncingBall.algorithms;

public class Position {
    private int direction;
    private int y;
    private int radius;

    public Position(int direction, int newY, int radius) {
        this.direction = direction;
        this.y = newY;
        this.radius = radius;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
