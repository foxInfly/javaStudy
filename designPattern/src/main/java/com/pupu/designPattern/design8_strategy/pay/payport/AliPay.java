package com.pupu.designPattern.design8_strategy.pay.payport;

/**
 * Created by Tom.
 */
public class AliPay extends Payment {

    @Override
    public String getPayChannelName() {
        return "支付宝";
    }
    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
