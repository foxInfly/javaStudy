package com.pupu.designPattern.design6_proxy.proxy1_staticproxy;

/**
 * @author lipu
 * @since 2020-09-02 14:12:00
 */
public class HouseAgent implements IBuyHouse {
    public void buyHouse() {
        System.out.println("您将要从 房产中介 那购买源城三期小三房一套");
    }
}
