package com.pupu.designPattern.design10_template.template02_course;

/**
 * Created by Tom.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("=========架构师课程=========");
        JavaCourse java = new JavaCourse();
        java.setNeedCheckHomework(true);
        java.createCourse();


        System.out.println("\n=========Python课程=========");
        PythonCourse python = new PythonCourse();
        python.createCourse();
    }
}
