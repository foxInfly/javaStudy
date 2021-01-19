package com.pupu.designPattern.design8_strategy.strategy03_pay.payport;

/**
 * Created by Tom.
 */
public class UnionPay extends Payment {

    @Override
    public String getPayChannelName() {
        return "银联支付";
    }
    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
