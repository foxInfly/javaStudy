package com.pupu.designPattern.design13_observer.gper;

import java.util.Observable;

/**被观察者
 * Created by Tom.
 */
public class GPer extends Observable {
    private String name = "GPer生态圈";
    private static final GPer gper = new GPer();

    private GPer() {}

    public static GPer getInstance(){
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
