package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.algorithms.BouncingBehaviour;
import com.tw.dojo.bouncingBall.algorithms.IStrategy;
import com.tw.dojo.bouncingBall.algorithms.Position;
import com.tw.dojo.bouncingBall.ui.BallWorld;

public class BouncingBall extends Ball {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;
    IStrategy strategy;

    BouncingBall(int x, int y, int direction) {
        super(x, y);
        this.direction = direction;
        strategy = new BouncingBehaviour();
    }

    @Override
    public void update() {
        Position newPosition = strategy.update(y, direction, radius);
        direction = newPosition.getDirection();
        y = newPosition.getY();
    }
}
