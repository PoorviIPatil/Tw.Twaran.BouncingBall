package com.tw.dojo.bouncingBall.algorithms;

import com.tw.dojo.bouncingBall.ui.BallWorld;

public class BouncingBehaviour implements IStrategy{
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int newY;
    private int bounceDirection;

    @Override
    public Position update(int y, int direction, int radius) {
        bounceDirection = reverseDirectionIfNecessary(y, direction, radius);
        newY = move(direction, y);
        return new Position(bounceDirection, newY, radius);
    }

    private int reverseDirectionIfNecessary(int y, int direction, int radius) {
        if (movingTooHigh(y, direction, radius) || movingTooLow(y, direction, radius)) {
            return switchDirection(direction);
        }

        return direction;
    }

    private boolean movingTooLow(int y, int direction, int radius) {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown(direction);
    }

    private boolean movingTooHigh(int y, int direction, int radius) {
        return y - radius <= 0 && movingUp(direction);
    }

    private int switchDirection(int direction) {
        return movingDown(direction) ? UP : DOWN;
    }

    private int move(int direction, int y) {
        return y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown(int direction) {
        return direction == DOWN;
    }

    private boolean movingUp(int direction) {
        return direction == UP;
    }
}
