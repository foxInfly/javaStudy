package com.pupu.designPattern.design1_factory.abstractfactory;

/**
 * @author : lipu
 * @since : 2020-09-01 23:24
 */
public class PythonCourseFactory extends CourseFactory{
    INote createNote() {
        super.init();
        return new PythonNote();
    }

    IVideo createVideo() {
        super.init();
        return new PythonVideo();
    }
}
