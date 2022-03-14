package com.tw.dojo.bouncingBall.algorithms;

public class ElasticBehaviour implements IStrategy{
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;
    static final int DEFAULT_RADIUS = 50;

    private int newGrowthDirection;
    private int newRadius;

    @Override
    public Position update(int y, int direction, int radius) {
        newGrowthDirection = reverseGrowthDirectionIfNecessary(direction, radius);
        newRadius = next(radius, direction);

        return new Position(newGrowthDirection, y, newRadius);
    }

    private int reverseGrowthDirectionIfNecessary(int direction, int radius) {
        if (growingTooBig(radius, direction) || shrinkingTooSmall(radius, direction)) {
            return switchDirection(direction);
        }
        return direction;
    }

    private boolean shrinkingTooSmall(int radius, int direction) {
        return radius <= 0 && shrinking(direction);
    }

    private boolean growingTooBig(int radius, int direction) {
        return radius >= DEFAULT_RADIUS && growing(direction);
    }

    private int switchDirection(int direction) {
        return growing(direction) ? SHRINK : GROW;
    }

    private int next(int radius, int growthDirection) {
        return radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking(int growthDirection) {
        return growthDirection == SHRINK;
    }

    private boolean growing(int growthDirection) {
        return growthDirection == GROW;
    }
}
