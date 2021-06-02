package com.pupu.designPattern.design12_visitor.visitor02_kpi;

import java.util.Random;

/**
 * 雇员
 *
 * @author lp
 * @since 2021/6/2 9:22
 */
public abstract class Employee {
    public String name;
    public int kpi;  //员工KPI

    public Employee(String name) {
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    //接收访问者的访问
    public abstract void accept(IVisitor visitor);
}
