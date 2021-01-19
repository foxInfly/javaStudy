package com.pupu.designPattern.design12_visitor.visitor01_general;

//抽象访问者
public interface IClient {

    /**访问房子A
     *
     * @param houseA  被访问的房子A
     */
    void visit(HouseA houseA);

    /**访问房子B
     *
     * @param houseB 被访问的房子B
     */
    void visit(HouseB houseB);
}