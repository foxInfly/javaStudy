package com.pupu.designPattern.design12_visitor.general;

/**
 * 房子A
 *    接受客户的餐馆
 */
public class HouseA implements IHouse {

    /**
     * 接受客户client的参观
     * @param client 参观的客户
     */
    public void accept(IClient client) {
        client.visit(this);
    }


    public String operationA() {
        System.out.println("HouseA 开始接受客户参观");
        return this.getClass().getSimpleName();
    }

}