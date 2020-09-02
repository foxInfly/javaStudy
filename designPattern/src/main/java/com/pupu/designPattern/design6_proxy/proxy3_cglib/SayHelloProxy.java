    package com.pupu.designPattern.design6_proxy.proxy3_cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
public class SayHelloProxy implements MethodInterceptor {

    //the target class who will be proxyed
    private Object target;

    public Object getInstance(Object target){
        this.target = target;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before==========");
        method.invoke(target,objects);
        System.out.println("end=============");
//        return methodProxy.invokeSuper(o, objects);
        return null;
    }
}