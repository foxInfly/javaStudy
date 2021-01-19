package com.pupu.designPattern.design8_strategy.strategy02_promotion;

/**提前把厕所放到集合中实现
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        String promotion = "";
//        IPromotionStrategy strategy = null;

//        PromotionActivity activity = new PromotionActivity(new GroupbuyStrategy());
//        activity.execute();
        PromotionStrategyFacory.getPromotionKeys();
        String promotionKey = "COUPON";

        IPromotionStrategy promotionStrategy = PromotionStrategyFacory.getPromotionStrategy(promotionKey);
        promotionStrategy.doPromotion();
    }
}
