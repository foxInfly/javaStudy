package com.pupu.designPattern.factory.simplefactory;

/**简单工厂模式
 * @author : lipu
 * @since : 2020-03-06 16:02
 */
public class SimpleFactory {

    public Pizza createPizza(String orderType){
        System.out.println("启动简单工厂模式~~");

        Pizza pizza = null;

        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        }else if(orderType.equals("cheeses")){
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        }

        return pizza;
    }
}
