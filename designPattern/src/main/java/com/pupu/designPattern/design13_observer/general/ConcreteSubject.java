package com.pupu.designPattern.design13_observer.general;

import java.util.ArrayList;
import java.util.List;

/**具体主题者(被观察者)
 * @author lipu
 * @since  2020/9/3 22:09
 */
public class ConcreteSubject<E> implements ISubject<E> {

    //观察者容器
    private List<IObserver<E>> observers = new ArrayList<IObserver<E>>();

    public boolean attach(IObserver<E> observer) {
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    public boolean detach(IObserver<E> observer) {
        return this.observers.remove(observer);
    }

    public void notify(E event) {
        for (IObserver<E> observer : this.observers) {
            observer.update(event);
        }
    }
}