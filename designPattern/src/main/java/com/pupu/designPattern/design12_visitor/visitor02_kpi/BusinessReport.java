package com.pupu.designPattern.design12_visitor.visitor02_kpi;

import java.util.LinkedList;
import java.util.List;

/**
 * 商业报表
 *
 * @author lp
 * @since 2021/6/2 9:19
 */
public class BusinessReport {

    //员雇员集合
    private List<Employee> employees = new LinkedList<>();

    //初始化员工集合,  ===其实就是初始化被访问者
    public BusinessReport() {
        employees.add(new Manager("产品经理A"));
        employees.add(new Manager("产品经理B"));
        employees.add(new Engineer("程序员A"));
        employees.add(new Engineer("程序员B"));
        employees.add(new Engineer("程序员C"));
        employees.add(new Engineer("程序员D"));
    }

    //show report
    public void showReport(IVisitor visitor) {
        for (Employee employee : employees) {
            employee.accept(visitor);
        }
    }
}
