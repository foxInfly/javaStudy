package com.pupu.designPattern.design6_proxy.proxy3_cglib;

/**
 * 目标被代理类
 */
public class SayHelloService {
    public void sayHello(){
        System.out.println("Hello");
    }

    public void sayBye(){
        System.out.println("Bye");
    }
}