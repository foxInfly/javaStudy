package com.pupu.designPattern.design13_observer.general;

/**
 * 被观察者
 * @author lipu
 * @since  2020/9/3 22:06
 */
public interface ISubject<E> {
    /**
     * 增加观察者
     * @param observer 观察者
     * @return boolean
     */
    boolean attach(IObserver<E> observer);

    /**
     * 删除观察者
     * @param observer 观察者
     * @return boolean
     */
    boolean detach(IObserver<E> observer);

    /**
     * 通知观察者
     * @param event 事件
     */
    void notify(E event);
}