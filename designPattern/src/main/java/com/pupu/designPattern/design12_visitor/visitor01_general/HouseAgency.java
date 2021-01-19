package com.pupu.designPattern.design12_visitor.visitor01_general;

import java.util.ArrayList;
import java.util.List;

//房产中介
public class HouseAgency {
    private List<IHouse> list = new ArrayList<>();

    //房源
    {
        this.list.add(new HouseA());
        this.list.add(new HouseB());
    }

    /**
     * 房产中介开始接待客户看房
     * @param client 看房客户
     */
    public void accept(IClient client) {
        System.out.println("房产中介开始接待 "+client.getClass().getSimpleName()+" 客户看房");
        for (IHouse house : this.list) {
            house.accept(client);
        }
    }
}