package com.pupu.designPattern.design13_observer.observer03_gper;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        GPer gper = GPer.getInstance();

        //注册观察者
        gper.addObserver(new Teacher("Tom"));
        gper.addObserver(new Teacher("Jerry"));

        //用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");

        gper.publishQuestion(question);
    }
}
