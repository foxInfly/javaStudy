package com.pupu.designPattern.design13_observer.observer01_general;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题者(被观察者)
 * 核心原理：
 * 1.观察者根据被观察者的状态做出相应的动作
 * 2.步骤1的动作，是由被观察者触发的，可以说是在被观察者中加入的了观察者的钩子函数
 *
 * @author lipu
 * @since 2020/9/3 22:09
 */
public class ConcreteObservable<E> implements IObservable<E> {

    //观察者容器
    private final List<IObserver<E>> observers = new ArrayList<>();

    public boolean attach(IObserver<E> observer) {
        if (this.observers.contains(observer)) return false;
        this.observers.add(observer);
        return true;
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