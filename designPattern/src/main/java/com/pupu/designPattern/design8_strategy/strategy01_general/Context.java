package com.pupu.designPattern.design8_strategy.strategy01_general;

/**
 * Context
 */
public class Context {
    private IStrategy mStrategy;

    public Context(IStrategy strategy) {
        this.mStrategy = strategy;
    }

    public void getAlgorithm() {
        this.mStrategy.algorithm();
    }
}