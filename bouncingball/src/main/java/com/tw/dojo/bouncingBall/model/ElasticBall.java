package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.algorithms.ElasticBehaviour;
import com.tw.dojo.bouncingBall.algorithms.IStrategy;
import com.tw.dojo.bouncingBall.algorithms.Position;

public class ElasticBall extends Ball {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int growthDirection;
    IStrategy strategy;

    ElasticBall(int x, int y, int radius, int growthDirection) {
        super(x, y, radius);
        this.growthDirection = growthDirection;
        strategy = new ElasticBehaviour();
    }

    @Override
    public void update() {
        Position newPosition = strategy.update(y, growthDirection, radius);
        growthDirection = newPosition.getDirection();
        radius = newPosition.getRadius();
    }

}
