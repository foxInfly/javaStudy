package com.pupu.designPattern.design13_observer.observer03_gper;

import java.util.Observable;

/**
 * 被观察者:咕泡生态圈
 * 功能：发布一个文章，所有订阅者都能收到信息
 * Created by Tom.
 */
public class GPer extends Observable {
    private String name = "GPer生态圈";
    private static final GPer gper = new GPer();

    private GPer() {
    }

    public static GPer getInstance() {
        return gper;
    }

    public String getName() {
        return name;
    }

    /**
     * 发布问题：其实就是触发一个事件event，就是question
     *
     */
    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();//设置状态改变，就算是发布订阅模式
        notifyObservers(question);//调用观察者，相当于向注册的观察者发射事件
    }
}
