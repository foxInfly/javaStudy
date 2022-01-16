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
    //1.事件源，动作是由谁发出的,记录事件的相关信息（发给谁，发的什么内容，谁发出的等等）
    private EventContext eventContext;

    //2.观察者，事件触发后，要通知的对象（观察者）
    private EventListener observer;

    //3.观察者给要执行的动作
    private Method method;

    //4.事件的名称
    private String eventName;

    //5.事件的触发时间
    private long time;

    public Event(EventListener observer, Method method) {
        this.observer = observer;
        this.method = method;
    }

    public Event setTime(long time) {
        this.time = time;
        return this;
    }

    public Method getMehod() {
        return method;
    }

    public EventListener getObserver() {
        return observer;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\neventContext=" + eventContext +
                ",\nobserver=" + observer +
                ",\nmethod=" + method +
                ",\neventName='" + eventName + '\'' +
                ", time=" + time +
                '}';
    }
}
