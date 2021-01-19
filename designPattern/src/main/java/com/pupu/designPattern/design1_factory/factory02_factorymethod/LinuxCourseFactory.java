package com.pupu.designPattern.design1_factory.factory02_factorymethod;

/**
 * @author : lipu
 * @since : 2020-09-01 22:32
 */
public class LinuxCourseFactory implements ICourseFactory {
    public ICourse create() {
        //要过滤，LinuxCourse
        return new LinuxCourse();
    }
}
