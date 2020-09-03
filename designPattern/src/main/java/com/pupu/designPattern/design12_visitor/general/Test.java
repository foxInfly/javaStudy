package com.pupu.designPattern.design12_visitor.general;

/**
 * Created by Tom.
 */
public class Test {

    public static void main(String[] args) {
        HouseAgency houseAgency = new HouseAgency();

        IClient clientA = new ClientA();
        houseAgency.accept(clientA);

        System.out.println("------------------------------------");

        IClient clientB = new ClientB();
        houseAgency.accept(clientB);
    }

}
