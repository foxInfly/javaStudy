package com.pupu.designPattern.design13_observer.observer02_mouseevent;

import com.pupu.designPattern.design13_observer.observer02_mouseevent.handler.Mouse;
import com.pupu.designPattern.design13_observer.observer02_mouseevent.handler.MouseEventLisenter;
import com.pupu.designPattern.design13_observer.observer02_mouseevent.handler.MouseEventType;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        //1.创建观察者
        MouseEventLisenter lisenter = new MouseEventLisenter();

        //2.创建被观察者
        Mouse mouse = new Mouse();
        //3.添加观察者
        mouse.addLisenter(MouseEventType.ON_CLICK,lisenter);
        mouse.addLisenter(MouseEventType.ON_MOVE,lisenter);

        mouse.click();
        mouse.move();
    }
}
