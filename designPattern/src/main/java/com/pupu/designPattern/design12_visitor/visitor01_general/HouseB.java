package com.pupu.designPattern.design12_visitor.visitor01_general;

import java.util.Random;

// 房子B
public class HouseB implements IHouse {

    //中介接收客户参观房子B，这个任务
    public void accept(IClient client) {
        client.visit(this);
    }

    //客户开始参观房子B
    public int operationB() {
        System.out.println("HouseB 开始接受客户参观");
        return new Random().nextInt(100);
    }
}