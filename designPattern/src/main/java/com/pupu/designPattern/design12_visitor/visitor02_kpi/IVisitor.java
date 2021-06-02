package com.pupu.designPattern.design12_visitor.visitor02_kpi;

/**
 * 访问者接口
 * @author lp
 * @since  2021/6/2 9:21
 */
public interface IVisitor {


    // 1 访问雇员
    void visit(Engineer engineer);


    // 2 访问管理着
    void visit(Manager manager);

}
