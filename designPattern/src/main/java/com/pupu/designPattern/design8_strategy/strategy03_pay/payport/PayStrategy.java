package com.pupu.designPattern.design8_strategy.strategy03_pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tom.
 */
public class PayStrategy {
    public static  final String ALI_PAY = "AliPay";
    public static  final String JD_PAY = "JdPay";
    public static  final String WECHAT_PAY = "WechatPay";
    public static  final String UNION_PAY = "UnionPay";
    public static  final String DEFAULT_PAY = ALI_PAY;

    //容器Map
    private static Map<String,Payment> strategy = new HashMap<String,Payment>();

    static {
        strategy.put(ALI_PAY,new AliPay());
        strategy.put(JD_PAY,new JDPay());
        strategy.put(WECHAT_PAY,new WechatPay());
        strategy.put(UNION_PAY,new UnionPay());
    }

    public static Payment get(String payKey){
        if(!strategy.containsKey(payKey)){
            return strategy.get(DEFAULT_PAY);
        }
        return strategy.get(payKey);
    }
}
