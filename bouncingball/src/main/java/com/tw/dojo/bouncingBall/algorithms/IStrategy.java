package com.tw.dojo.bouncingBall.algorithms;

public interface IStrategy {
    Position update(int y, int direction, int radius);
}
