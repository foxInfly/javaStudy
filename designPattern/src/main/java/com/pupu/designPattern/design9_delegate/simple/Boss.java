package com.pupu.designPattern.design9_delegate.simple;

/**
 * Created by Tom.
 */
public class Boss {
    public void command(String task,Leader leader){
        leader.doing(task);
    }
}
