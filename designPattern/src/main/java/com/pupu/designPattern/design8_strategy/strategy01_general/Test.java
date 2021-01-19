package com.pupu.designPattern.design8_strategy.strategy01_general;

/** 多态实现strategy
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        //select one ConcreteStrategy,多态
        IStrategy strategy = new ConcreteStrategyA();
        //来一个上下文环境
        Context context = new Context(strategy);
        //客户端直接让上下文环境执行算法
        context.getAlgorithm();
    }
}
