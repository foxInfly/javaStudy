package com.pupu.designPattern.design8_strategy.strategy02_promotion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** 提前把策略放到一个集合中
 * Created by Tom.
 */
public class PromotionStrategyFacory {

    private static Map<String,IPromotionStrategy> PROMOTIONS = new HashMap<>();

    static {
        PROMOTIONS.put(PromotionKey.COUPON,new CouponStrategy());
        PROMOTIONS.put(PromotionKey.CASHBACK,new CashbackStrategy());
        PROMOTIONS.put(PromotionKey.GROUPBUY,new GroupbuyStrategy());
    }

    private static final IPromotionStrategy EMPTY = new EmptyStrategy();

    private PromotionStrategyFacory(){}

    public static IPromotionStrategy getPromotionStrategy(String promotionKey){
        IPromotionStrategy strategy = PROMOTIONS.get(promotionKey);
        return strategy == null ? EMPTY : strategy;
    }
    private interface PromotionKey{
        String COUPON = "COUPON";
        String CASHBACK = "CASHBACK";
        String GROUPBUY = "GROUPBUY";
    }

    /**初始化策略
     **/
    public static  Set<String> getPromotionKeys(){
        return PROMOTIONS.keySet();
    }
}
