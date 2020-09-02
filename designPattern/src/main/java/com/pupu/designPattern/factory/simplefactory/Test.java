package com.pupu.designPattern.factory.simplefactory;

import java.util.Random;

/**
 * @author : lipu
 * @since : 2020-09-01 20:29
 */
public class Test {

    public static void main(String[] args) throws Exception{
        String[] courses= new String[3];
        courses[0]="com.pupu.designPattern.factory.simplefactory.PythonCourse";
        courses[1]="com.pupu.designPattern.factory.simplefactory.LinuxCourse";
        courses[2]="com.pupu.designPattern.factory.simplefactory.JavaCourse";
        for (int i = 0; i < 10; i++) {
            int j = new Random().nextInt(3);
            ICourse course = SimpleFactory.createCourse(courses[j]);
            String courseName = course.getName();
            System.out.println("我是一门 "+ courseName +"课程");
        }

    }
}
