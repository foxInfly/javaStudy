package com.pupu.designPattern.design12_visitor.visitor01_general;

import java.util.ArrayList;
import java.util.List;

/**
 * 房产中介
 *
 * @author lp
 * @since 2021/6/2 9:06
 */
public class HouseAgency {

    //房产中介所拥有的的房子集合
    private List<IHouse> list = new ArrayList<>();

    //初始化房源
    {
        this.list.add(new HouseA());
        this.list.add(new HouseB());
    }

    /**
     * 房产中介开始接待客户看房
     *
     * @param client 具体的某个看房客户
     */
    public void accept(IClient client) {
        System.out.println("房产中介开始接待 " + client.getClass().getSimpleName() + " 客户看房");

        for (IHouse house : this.list) {
            house.accept(client);
        }
    }
}