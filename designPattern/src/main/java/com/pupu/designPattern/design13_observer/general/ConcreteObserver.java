package com.pupu.designPattern.design13_observer.general;

/**具体观察者
 * @author lipu
 * @since  2020/9/3 22:09
 */
public class ConcreteObserver<E> implements IObserver<E> {
    public void update(E event) {
        System.out.println("receive event: " + event);
    }
}