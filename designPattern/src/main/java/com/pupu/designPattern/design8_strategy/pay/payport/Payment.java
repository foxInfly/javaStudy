package com.pupu.designPattern.design8_strategy.pay.payport;

import com.pupu.designPattern.design8_strategy.pay.MsgResult;

/**
 * Created by Tom.
 */
public abstract class Payment {

    /**get the name of Payment Channel
     * @return String
     */
    public abstract String getPayChannelName();

    /**pay service
     *
     * @param uid 用户id
     * @param amount 要支付的金额
     * @return MsgResult
     */
    public MsgResult pay(String uid, double amount){
        //余额是否足够
        if(queryBalance(uid) < amount){
            return new MsgResult(500,"支付失败","余额不足");
        }
        return new MsgResult(200,"支付成功","支付金额" + amount);
    }

    /**query balance by the id of user
     * @param uid 用户id
     * @return double 余额
     */
    protected abstract double queryBalance(String uid);
}
