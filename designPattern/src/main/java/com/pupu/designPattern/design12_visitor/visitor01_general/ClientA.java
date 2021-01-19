package com.pupu.designPattern.design12_visitor.visitor01_general;

/**
 * 看房客户A
 */
public class ClientA implements IClient {

    /**
     * 参观房子
     * @param houseA  被访问的房子A
     */
    public void visit(HouseA houseA) {
        String result = houseA.operationA();
        System.out.println("参观房子： "  + result);
    }

    public void visit(HouseB houseB) {
        int result = houseB.operationB();
        System.out.println("参观房子： " + result);
    }
}