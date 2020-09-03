package com.pupu.designPattern.design5_adapter.general.objectadapter;

/**
 * Created by Tom.
 */
public class Adapter implements Target {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    public int request() {
        return adaptee.specificRequest() / 10;
    }
}
