package com.pupu.designPattern.design11_chain.general;

public abstract class Handler {

    protected Handler nextHandler;

    public void setNextHanlder(Handler successor) {
        this.nextHandler = successor;
    }

    public abstract void handleRequest(String request);

}