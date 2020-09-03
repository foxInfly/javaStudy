package com.pupu.designPattern.design12_visitor.general;

// 具体访问者
public class ClientB implements IClient {

    public void visit(HouseA houseA) {
        String result = houseA.operationA();
        System.out.println("参观房子： "  + result);
    }


    public void visit(HouseB houseB) {
        int result = houseB.operationB();
        System.out.println("参观房子： "  + result);
    }
}