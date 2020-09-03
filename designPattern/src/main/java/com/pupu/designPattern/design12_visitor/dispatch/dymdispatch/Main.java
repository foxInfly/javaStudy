package com.pupu.designPattern.design12_visitor.dispatch.dymdispatch;

/**
 * Created by Tom.
 */
public class Main {
    public static void main(String[] args) {
        Person man = new Man();
        Person woman = new WoMan();

        man.test();
        woman.test();
    }
}
