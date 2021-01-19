package com.pupu.designPattern.design13_observer.observer01_general;

/**观察者
 * @author lipu
 * @since  2020/9/3 22:07
 */
public interface IObserver<E> {

    /**
     * 响应被观察者发来的通知
     * @param event 事件
     */
    void update(E event);
}