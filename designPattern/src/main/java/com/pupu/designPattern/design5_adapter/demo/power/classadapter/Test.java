package com.pupu.designPattern.design5_adapter.demo.power.classadapter;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        DC5 adapter = new PowerAdapter();
        adapter.output5V();
    }
}
