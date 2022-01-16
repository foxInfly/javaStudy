package com.pupu.designPattern.design13_observer.observer02_mouseevent.handler;

import com.pupu.designPattern.design13_observer.observer02_mouseevent.core.EventContext;

/**
 * 具体的被观察者
 * Created by Tom.
 */
public class Mouse extends EventContext {
    public void click(){
        System.out.println("我是被观察者：准备触发click...");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void move(){
        System.out.println("我是被观察者：准备触发move...");
        this.trigger(MouseEventType.ON_MOVE);
    }
}
