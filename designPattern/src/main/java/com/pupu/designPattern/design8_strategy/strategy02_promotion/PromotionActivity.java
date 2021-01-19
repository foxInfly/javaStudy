package com.pupu.designPattern.design8_strategy.strategy02_promotion;

/**打折活动
 * Created by Tom.
 */
public class PromotionActivity {
    private IPromotionStrategy strategy;

    public PromotionActivity(IPromotionStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(){
        strategy.doPromotion();
    }
}
