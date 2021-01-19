package com.pupu.designPattern.design16_composite.comosite01_general.safe;

// 抽象根节点
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String operation();
}