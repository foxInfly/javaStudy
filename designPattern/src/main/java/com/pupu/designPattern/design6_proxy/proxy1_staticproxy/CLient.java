package com.pupu.designPattern.design6_proxy.proxy1_staticproxy;

/**
 * @author lipu
 * @since 2020-09-02 14:04:27
 */
public class CLient {

    public static void main(String[] args) {
        System.out.println("从开发商处直接买房：");
        new Developers().buyHouse();
        System.out.println();
        System.out.println("=============================");
        System.out.println();
        System.out.println("从 房产中介 处买房：");
        new HouseAgent().buyHouse();
    }
}
