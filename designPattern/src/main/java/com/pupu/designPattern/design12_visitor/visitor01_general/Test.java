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

        //3、房产中介接受带客户A参观房子任务；最终是中介A，带客户A，指定房子，房子调客户A，客户A调房子A；  来回调，逻辑不一样
        houseAgency.accept(clientA);

        System.out.println("\n------------------------------------\n");

        IClient clientB = new ClientB();
        houseAgency.accept(clientB);
    }

}
