package com.pupu.designPattern.design12_visitor.visitor02_kpi;

/**
 * CEO visitor
 *
 * @author lp
 * @since 2021/6/2 9:23
 */
public class CEOVisitor implements IVisitor {


    public void visit(Engineer engineer) {
        System.out.println("工程师：" + engineer.name + "，KPI：" + engineer.kpi);
    }

    public void visit(Manager manager) {
        System.out.println("经理：" + manager.name + ",KPI:" + manager.kpi + "，产品数量：" + manager.getProducts());
    }
}
