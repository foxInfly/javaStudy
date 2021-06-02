package com.pupu.designPattern.design12_visitor.visitor02_kpi;

import java.util.Random;

/**
 * 管理着
 *
 * @author lp
 * @since 2021/6/2 9:25
 */
public class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    //考核的是每年新产品研发数量
    public int getProducts() {
        return new Random().nextInt(10);
    }
}
