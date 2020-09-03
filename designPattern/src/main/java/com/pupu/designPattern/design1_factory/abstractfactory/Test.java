package com.pupu.designPattern.design1_factory.abstractfactory;

/**
 * @author : lipu
 * @since : 2020-09-01 23:28
 */
public class Test {

    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
