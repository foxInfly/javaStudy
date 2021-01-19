package com.pupu.designPattern.design12_visitor.visitor01_general;

// 房子
public interface IHouse {

    //接受访问者的访问
    void accept(IClient client);
}