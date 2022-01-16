package com.pupu.designPattern.design13_observer.observer02_mouseevent.core;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 被观察者的抽象
 * Created by Tom.
 */
public class EventContext {
    //存放观察者（事件）的容器 key:属于观察者的某个事件的类型名，value：事件对象
    protected Map<String,Event> events = new HashMap<>();

    /**
     * 添加观察者
     * @param eventType 事件类型
     * @param target 观察者
     * @param callback 回调方法
     */
    public void addLisenter(String eventType, EventListener target, Method callback){
        events.put(eventType,new Event(target,callback));
    }

    /**
     * 添加观察者的某个观察点（事件）
     * @param eventType 事件类型属于对应的观察者的
     * @param target 观察者
     */
    public void addLisenter(String eventType, EventListener target){
        try {
            String methodName = "on" + toUpperFirstCase(eventType);
            Method method = target.getClass().getMethod(methodName, Event.class);
            this.addLisenter(eventType, target,method );
        }catch (NoSuchMethodException e){
            throw new RuntimeException("addLisenter ...");
        }
    }

    /**
     * 首字母大些
     * @param eventType 事件类型
     */
    private String toUpperFirstCase(String eventType) {
        char [] chars = eventType.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

    /**
     * 事件触发器
     * @param event 事件
     */
    private void trigger(Event event){
        event.setEventContext(this);
        event.setTime(System.currentTimeMillis());

        //通过发射调用，触发观察者对应的事件
        try {
            if (event.getMehod() != null) {
                event.getMehod().invoke(event.getObserver(), event);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 触发事件
     * @param eventName 事件名称
     */
    protected void trigger(String eventName){
        if(!this.events.containsKey(eventName)){return;}
        trigger(this.events.get(eventName).setEventName(eventName));
    }

}
