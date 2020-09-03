package com.pupu.designPattern.design8_strategy.general;

/** 好像工厂模式
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        //select one ConcreteStrategy
        IStrategy strategy = new ConcreteStrategyA();
        //来一个上下文环境
        Context context = new Context(strategy);
        //客户端直接让上下文环境执行算法
        context.algorithm();
    }
}
