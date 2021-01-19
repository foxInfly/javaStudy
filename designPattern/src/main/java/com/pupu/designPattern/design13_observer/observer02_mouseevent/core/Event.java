package com.pupu.designPattern.design13_observer.observer02_mouseevent.core;

import lombok.Data;
import lombok.experimental.Accessors;

import java.lang.reflect.Method;

/**
 * Created by Tom.
 */
@Data
@Accessors(chain = true)
public class Event {
    //事件源，动作是由谁发出的
    private Object source;

    //事件触发，要通知谁（观察者）
    private EventListener target;

    //观察者给的回应
    private Method callback;

    //事件的名称
    private String trigger;

    //事件的触发时间
    private long time;

    public Event(EventListener target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    public EventListener getTarget() {
        return target;
    }

}
