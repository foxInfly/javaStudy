package com.pupu.designPattern.design8_strategy.pay.payport;

/**
 * Created by Tom.
 */
public class WechatPay extends Payment {

    @Override
    public String getPayChannelName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 263;
    }
}
