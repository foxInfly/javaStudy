package com.pupu.designPattern.design13_observer.observer02_mouseevent.handler;

import com.pupu.designPattern.design13_observer.observer02_mouseevent.core.Event;
import com.pupu.designPattern.design13_observer.observer02_mouseevent.core.EventListener;

/**
 * 观察者
 * Created by Tom.
 */
public class MouseEventLisenter implements EventListener {

    public void onClick(Event e){
        System.out.println("我是观察者：观察到click事件" + e);
    }

    public void onMove(Event e){
        System.out.println("我是观察者：观察到move事件\n" + e);
    }
}
