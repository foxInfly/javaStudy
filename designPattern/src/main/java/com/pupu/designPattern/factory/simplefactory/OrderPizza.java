package com.pupu.designPattern.factory.simplefactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**订购披萨
 * @author : lipu
 * @since : 2020-03-06 14:53
 */
public class OrderPizza {

    //构造器
//    public OrderPizza() {
//        Pizza pizza = null;
//        //订购的披萨类型
//        String orderType;
//        do {
//            orderType = getType();
//            if (orderType.equals("greek")) {
//                pizza = new GreekPizza();
//                pizza.setName("希腊披萨");
//            }else if(orderType.equals("cheeses")){
//                pizza = new CheesePizza();
//                pizza.setName("奶酪披萨");
//            }else {
//                break;
//            }
//            //输出pizza制作过程
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//            System.out.println(pizza.name+" 制作完成并打包。。。");
//        }while (true);
//    }

    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    //构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }

    public void setSimpleFactory(SimpleFactory simpleFactory) {
        //用户输入的
        String orderType = "";

        //简单工厂对象
        this.simpleFactory = simpleFactory;

        do{
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            //输出pizza制作过程
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
                System.out.println(pizza.name+" 制作完成并打包。。。");
            }else {
                System.out.println(" 制作失败。。。");
                break;
            }
        }while (true);
    }

    //获取客户希望订购的披萨种类
    private String getType(){
        BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("pupu披萨店开始营业，\n目前，可以生产的披萨有：greek、cheese;");
        System.out.print("input pizza Type : ");
        String str = null;
        try {
            str = strin.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
