package com.pupu.designPattern.design8_strategy.pay.payport;

/**
 * Created by Tom.
 */
public class JDPay extends Payment {

    @Override
    public String getPayChannelName() {
        return "京东白条";
    }
    @Override
    protected double queryBalance(String uid) {
        return 500;
    }
}
