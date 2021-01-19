package com.pupu.designPattern.design13_observer.observer02_mouseevent.handler;

import com.pupu.designPattern.design13_observer.observer02_mouseevent.core.EventContext;

/**
 * 具体的被观察者
 * Created by Tom.
 */
public class Mouse extends EventContext {
    public void click(){
        System.out.println("调用单击方法");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void move(){
        System.out.println("调用移动方法");
        this.trigger(MouseEventType.ON_MOVE);
    }
}
