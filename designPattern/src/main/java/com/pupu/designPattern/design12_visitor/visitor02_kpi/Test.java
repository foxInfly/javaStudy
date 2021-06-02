package com.pupu.designPattern.design12_visitor.visitor02_kpi;

/**
 * 访问者模式：
 *     将更新（变更）封装到一个类中（访问操作），并由待更改类提供一个接收接口，则可达到效果。
 *
 *  访问者  ：CEO、CTO
 *  被访问者：engineer、manager
 *  客户端：就是本测试类Test
 *
 *  程序流程：
 *     1、客户端内收访问者，
 *     2、客户端通过被访问者接收访问者的访问
 *     3、被访问者然后通过访问调自己，达到  访问者访问被访问者的目的
 */
public class Test {
    public static void main(String[] args) {
        BusinessReport report = new BusinessReport();

        System.out.println("==========CEO看报表===============");
        report.showReport(new CEOVisitor());

        System.out.println("\n==========CTO看报表===============");

        report.showReport(new CTOVistitor());
    }
}
