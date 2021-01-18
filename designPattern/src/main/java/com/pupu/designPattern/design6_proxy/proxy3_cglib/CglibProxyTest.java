package com.pupu.designPattern.design6_proxy.proxy3_cglib;

/**
 *
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        SayHelloService sayHelloService = new SayHelloService();

        SayHelloProxy sayHelloProxy = new SayHelloProxy();

        SayHelloService sayHelloServiceproxy = (SayHelloService) sayHelloProxy.getInstance(sayHelloService);

        sayHelloServiceproxy.sayHello();
        sayHelloServiceproxy.sayBye();
    }
}