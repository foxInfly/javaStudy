package com.pupu.designPattern.factory.simplefactory;

/**披萨店，相当于客户端，发出订购
 * @author : lipu
 * @since : 2020-03-06 15:04
 */
public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza();

        //使用简单工厂模式
        new OrderPizza(new SimpleFactory());
        System.out.println("~~披萨店下班了~~");
    }
}
