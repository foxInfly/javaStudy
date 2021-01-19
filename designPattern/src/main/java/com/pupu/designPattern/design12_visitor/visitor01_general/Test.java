package com.pupu.designPattern.design12_visitor.visitor01_general;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        //1.创建房产中介
        HouseAgency houseAgency = new HouseAgency();

        //2.创建客户
        IClient clientA = new ClientA();

        houseAgency.accept(clientA);

        System.out.println("\n------------------------------------\n");

        IClient clientB = new ClientB();
        houseAgency.accept(clientB);
    }

}
