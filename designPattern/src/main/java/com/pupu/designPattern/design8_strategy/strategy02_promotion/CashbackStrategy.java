package com.pupu.designPattern.design8_strategy.strategy02_promotion;

/**
 * Created by Tom.
 */
public class CashbackStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("返现，直接打款到支付宝账号");
    }
}
