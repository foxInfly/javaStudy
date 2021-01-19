package com.pupu.designPattern.design1_factory.factory03_abstractfactory;

/**
 * @author : lipu
 * @since : 2020-09-01 23:20
 */
public abstract class CourseFactory {

    //编写笔记对象
    abstract INote createNote();
    //录制视频对象
    abstract IVideo createVideo();

    //初始化基础数据
    public void init(){
        System.out.println("初始化基础数据");
    }

}
