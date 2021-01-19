package com.pupu.designPattern.design12_visitor.visitor02_kpi;

/**
 * Created by Tom.
 */
public interface IVisitor {

    void visit(Engineer engineer);

    void visit(Manager manager);

}
