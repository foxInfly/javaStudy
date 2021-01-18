package com.pupu.designPattern.design1_factory.simplefactory;

/**
 * 简单工厂模式
 *
 * @author : lipu
 * @since : 2020-03-06 16:02
 */
public class SimpleFactory {

    public static ICourse createCourse(String classPath) throws Exception {
        return (ICourse) Class.forName(classPath).newInstance();
    }
}
