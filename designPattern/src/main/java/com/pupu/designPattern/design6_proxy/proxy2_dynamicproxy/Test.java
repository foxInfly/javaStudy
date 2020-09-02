package com.pupu.designPattern.design6_proxy.proxy2_dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author lipu
 * @since 2020-09-02 14:57:45
 */
public class Test {

    public static void main(String[] args) {
        Car developer = new Developer();
        developer.buyCar();
        Car carProxy = (Car) Proxy.newProxyInstance(Developer.class.getClassLoader(), Developer.class.getInterfaces(), new HouseAgent());
        carProxy.buyCar();
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println();
        Car carproxy1 = Test.createSimple(developer);
        carproxy1.buyCar();
    }

    //方法增强
    private static Car createSimple(Car object) {
        return (Car) Proxy.newProxyInstance(Developer.class.getClassLoader(), Developer.class.getInterfaces()
                , ((proxy, method, args) -> {
                    System.out.println("联系房产中介");
                    method.invoke(object, args);
                    System.out.println("与房产中介交易");
                    return null;
                }));
    }
}
