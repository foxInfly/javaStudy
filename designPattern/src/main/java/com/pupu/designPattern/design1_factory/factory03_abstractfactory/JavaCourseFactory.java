package com.pupu.designPattern.design1_factory.factory03_abstractfactory;

/**
 * @author : lipu
 * @since : 2020-09-01 23:24
 */
public class JavaCourseFactory extends CourseFactory{
    INote createNote() {
        super.init();
        return new JavaNote();
    }

    IVideo createVideo() {
        super.init();
        return new JavaVideo();
    }
}
