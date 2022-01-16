package com.pupu.designPattern.design13_observer.observer03_gper;

import java.util.Observable;
import java.util.Observer;

/**观察者：老师类
 * Created by Tom.
 */
public class Teacher implements Observer {

    /**teache name*/
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    /**
     * 当被观察者（Gper）发布了新问题，观察者（老师）更新相关信息
     *
     * @param observable 被观察者，这个案例中就是GPer生态圈
     * @param arg argument
     */
    public void update(Observable observable, Object arg) {
        GPer gper = (GPer)observable;
        Question question = (Question)arg;
        System.out.println("======================");
        System.out.println(name + "老师，你好！\n" +
                        "您收到了一个来自" + gper.getName() + "的提问，希望您解答。问题内容如下：\n" +
                        question.getContent() + "\n" +
                        "提问者：" + question.getUserName());
    }
}
