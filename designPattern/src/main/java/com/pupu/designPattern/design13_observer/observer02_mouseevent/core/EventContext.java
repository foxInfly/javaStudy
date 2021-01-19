package com.pupu.designPattern.design13_observer.observer02_mouseevent.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 被观察者的抽象
 * Created by Tom.
 */
public class EventContext {
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
     * 添加观察者
     * @param eventType 事件类型
     * @param target 观察者
     */
    public void addLisenter(String eventType, EventListener target){
        try {
            this.addLisenter(eventType, target, target.getClass().getMethod("on" + toUpperFirstCase(eventType), Event.class));
        }catch (NoSuchMethodException e){
            throw new RuntimeException("...");
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
        event.setSource(this);
        event.setTime(System.currentTimeMillis());

        try {
            if (event.getCallback() != null) {
                event.getCallback().invoke(event.getTarget(), event);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 触发事件
     * @param trigger 事件
     */
    protected void trigger(String trigger){
        if(!this.events.containsKey(trigger)){return;}
        trigger(this.events.get(trigger).setTrigger(trigger));
    }
}
