package com.pupu.designPattern.design5_adapter.general.classadapter;

/**
 * 累的适配器模式
 */
public class Test {

    public static void main(String[] args) {
        Target adapter = new Adapter();

        int result = adapter.request();

        System.out.println(result);
    }

}
