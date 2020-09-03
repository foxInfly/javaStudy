package com.pupu.designPattern.design13_observer.mouseevent;

import com.pupu.designPattern.design13_observer.mouseevent.handler.Mouse;
import com.pupu.designPattern.design13_observer.mouseevent.handler.MouseEventLisenter;
import com.pupu.designPattern.design13_observer.mouseevent.handler.MouseEventType;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        MouseEventLisenter lisenter = new MouseEventLisenter();

        Mouse mouse = new Mouse();
        mouse.addLisenter(MouseEventType.ON_CLICK,lisenter);
        mouse.addLisenter(MouseEventType.ON_MOVE,lisenter);

        mouse.click();
        mouse.move();
    }
}
