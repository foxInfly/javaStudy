package com.pupu.designPattern.design5_adapter.demo.power.classadapter;

/**
 * Created by Tom.
 */
public class AC220 {
    public int outputAC220V(){
        int output = 220;
        System.out.println("输出电压" + output + "V");
        return output;
    }
}
