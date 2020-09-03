package com.pupu.designPattern.design13_observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Tom.
 */
public class VoEvent {

    //观察者的回调
    @Subscribe
    public void observer(Vo arg){
//        if(arg instanceof Vo){
            System.out.println("执行VoEvent方法，Vo传参为：" + arg);
//        }

    }

}
