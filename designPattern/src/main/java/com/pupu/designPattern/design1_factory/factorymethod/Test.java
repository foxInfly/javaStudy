package com.pupu.designPattern.design1_factory.factorymethod;

/**
 * @author : lipu
 * @since : 2020-09-01 22:33
 */
public class Test {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();

        ICourse course = factory.create();
        System.out.println(course.getName());
    }
}
