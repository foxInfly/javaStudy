package com.pupu.designPattern.design8_strategy.pay;

import com.pupu.designPattern.design8_strategy.pay.payport.PayStrategy;
import com.pupu.designPattern.design8_strategy.pay.payport.Payment;

/**订单
 * Created by Tom.
 */
public class Order {
    private String uid;//用户id
    private String orderId;//订单id
    private double amount;//金额

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public MsgResult pay(){
        return pay(PayStrategy.DEFAULT_PAY);
    }

    public MsgResult pay(String payKey){
        Payment payment = PayStrategy.get(payKey);
        System.out.println("欢迎使用" + payment.getPayChannelName());
        System.out.println("本次交易金额为" + amount + "，开始扣款");
        return payment.pay(uid,amount);
    }
}
