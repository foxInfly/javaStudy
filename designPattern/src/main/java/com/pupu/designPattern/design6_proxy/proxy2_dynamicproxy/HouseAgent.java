package com.pupu.designPattern.design6_proxy.proxy2_dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lipu
 * @since 2020-09-02 15:21:30
 */
public class HouseAgent implements InvocationHandler {

    //当通过代理类的对象发起对被重写的方法调用时，都会转换为对如下的invoke方法的调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("从 房产中介 买房");
        return null;
    }
}
