package com.pupu.designPattern.design5_adapter.general.interfaceadapter;


/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        Target adapter = new Adapter(new Adaptee()) {
            @Override
            public int request1() {
                //这不是做了装饰，再处理吗
                return adaptee.specificRequest() / 10;
            }
        };
        int result = adapter.request1();
        System.out.println(result);
    }
}
