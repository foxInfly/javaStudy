package com.pupu.designPattern.design10_template.template01_general;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        AbstractClass abc = new ConcreteClassA();
        abc.templateMehthod();

        System.out.println("\n============================\n");
        abc = new ConcreteClassB();
        abc.templateMehthod();
    }
}
