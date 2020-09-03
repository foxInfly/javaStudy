package com.pupu.designPattern.design17_bridge.message;

/**
 * Created by Tom.
 */
public interface IMessage {
    //发送消息的内容和接收人
    void send(String message, String toUser);
}
