package com.pupu.designPattern.design13_observer.observer01_general;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        // 被观察者
        IObservable<String> observable = new ConcreteObservable<>();

        // 观察者
        IObserver<String> observer = new ConcreteObserver<>();
        IObserver<String> observer2 = new ConcreteObserver<>();

        // 注册
        observable.attach(observer);
        observable.attach(observer2);

        // 通知
        observable.notify("hello");
    }

}
