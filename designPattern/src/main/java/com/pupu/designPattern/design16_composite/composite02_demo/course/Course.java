package com.pupu.designPattern.design16_composite.composite02_demo.course;

/**
 * Created by Tom.
 */
public class Course extends CourseComponent {

    /**课程名称*/
    private String name;
    /**课程价格*/
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(name + " (￥" + price + "元)");
    }

}
