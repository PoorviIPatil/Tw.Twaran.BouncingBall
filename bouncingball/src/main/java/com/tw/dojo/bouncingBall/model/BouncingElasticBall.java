package com.tw.dojo.bouncingBall.model;

import com.tw.dojo.bouncingBall.algorithms.BouncingBehaviour;
import com.tw.dojo.bouncingBall.algorithms.ElasticBehaviour;
import com.tw.dojo.bouncingBall.algorithms.IStrategy;
import com.tw.dojo.bouncingBall.algorithms.Position;

public class BouncingElasticBall extends Ball {
    private int growthDirection;
    private int direction;
    IStrategy bouncingStrategy;
    IStrategy elasticStrategy;

    protected BouncingElasticBall(int x, int y, int radius, int direction, int growthDirection) {
        super(x, y, radius);
        this.direction = direction;
        this.growthDirection = growthDirection;
        bouncingStrategy = new BouncingBehaviour();
        elasticStrategy = new ElasticBehaviour();
    }

    @Override
    public void update() {
        Position newPositionBouncing = bouncingStrategy.update(y,direction,radius);
        Position newPositionElastic = elasticStrategy.update(y,growthDirection,radius);

        direction = newPositionBouncing.getDirection();
        y = newPositionBouncing.getY();
        growthDirection = newPositionElastic.getDirection();
        radius = newPositionElastic.getRadius();

    }
}
