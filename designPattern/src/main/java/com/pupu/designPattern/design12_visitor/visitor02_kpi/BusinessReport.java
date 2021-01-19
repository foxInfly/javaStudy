package com.pupu.designPattern.design12_visitor.visitor02_kpi;

import java.util.LinkedList;
import java.util.List;

/**报表
 * Created by Tom.
 */
public class BusinessReport {
    private List<Employee> employees = new LinkedList<>();

    public BusinessReport() {
        employees.add(new Manager("产品经理A"));
        employees.add(new Manager("产品经理B"));
        employees.add(new Engineer("程序员A"));
        employees.add(new Engineer("程序员B"));
        employees.add(new Engineer("程序员C"));
        employees.add(new Engineer("程序员D"));
    }

    public void showReport(IVisitor visitor){
        for (Employee employee : employees) {
            employee.accept(visitor);
        }
    }
}
