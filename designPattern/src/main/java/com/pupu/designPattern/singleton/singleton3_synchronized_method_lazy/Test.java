package com.pupu.designPattern.singleton.singleton3_synchronized_method_lazy;

/**
 * @author lipu
 * @since 2020-09-02 10:19:04
 */
public class Test {

    public static void main(String[] args) {
        Car car = Car.getInstance();
        System.out.println(car);
    }
}
