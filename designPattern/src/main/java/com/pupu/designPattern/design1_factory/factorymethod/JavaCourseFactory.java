package com.pupu.designPattern.design1_factory.factorymethod;

/**
 * @author : lipu
 * @since : 2020-09-01 22:32
 */
public class JavaCourseFactory implements ICourseFactory {
    public ICourse create() {
        //要过滤，只创建JavaCourse
        return new JavaCourse();
    }
}
