package com.pupu.designPattern.design12_visitor.general;

import java.util.Random;

// 房子B
public class HouseB implements IHouse {

    public void accept(IClient client) {
        client.visit(this);
    }

    public int operationB() {
        System.out.println("HouseB 开始接受客户参观");
        return new Random().nextInt(100);
    }
}