package com.pupu.designPattern.design6_proxy.proxy1_staticproxy;

/**
 * 教学
 *  1) 定义一个接口:ITeacherDao
 * 	2) 目标对象 TeacherDAO 实现接口 ITeacherDAO
 * 	3) 使用静态代理方式,就需要在代理对象 TeacherDAOProxy 中也实现 ITeacherDAO
 * 	4) 调用的时候通过调用代理对象的方法来调用目标对象.
 * 	5) 特别提醒：代理对象与目标对象要实现相同的接口,然后通过调用相同的方法来调用目标对象的方法
 * 思路分析图解(类图)
 *
 * @author lipu
 * @since 2020-09-02 14:06:02
 */
public interface IBuyHouse {

    void buyHouse();
}
