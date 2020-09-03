package com.pupu.designPattern.design13_observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * Created by Tom.
 */
public class PojoEvent {

    @Subscribe
    public void observer(Pojo pojo){
//        if(arg instanceof Pojo){
            System.out.println("执行PojoEvent方法，传参为：" + pojo);
//        }
    }

}
