package com.pupu.designPattern.design1_factory.abstractfactory;

/**
 * @author : lipu
 * @since : 2020-09-01 23:20
 */
public abstract class CourseFactory {

    //创建笔记对象
    abstract INote createNote();
    //创建录制视频对象
    abstract IVideo createVideo();

    //初始化基础数据
    public void init(){
        System.out.println("初始化基础数据");
    }

}
