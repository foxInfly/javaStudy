package com.pupu.designPattern.design12_visitor.visitor01_general;

/**
 * 房子
 * @author lp
 * @since  2021/6/2 9:08
 */
public interface IHouse {

    //接受访问者的访问
    void accept(IClient client);
}