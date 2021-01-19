package com.pupu.designPattern.design12_visitor.visitor02_kpi;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        BusinessReport report = new BusinessReport();
        System.out.println("==========CEO看报表===============");
        report.showReport(new CEOVistitor());
        System.out.println("\n==========CTO看报表===============");
        report.showReport(new CTOVistitor());
    }
}
