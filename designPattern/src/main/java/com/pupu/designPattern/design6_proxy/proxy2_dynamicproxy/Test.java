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

    }
}
