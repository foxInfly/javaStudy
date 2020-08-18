package com.pupu.designPattern.factory.simplefactory;

/**
 * 披萨类
 *
 * @author : lipu
 * @since : 2020-03-06 14:40
 */
public abstract class Pizza {
    //披萨名字
    protected String name;

    //准备原材料，不同的披萨，原材料不一样
    public abstract void prepare();

    public void bake(){
        System.out.println(name+" baking");
    }

    public void cut(){
        System.out.println(name+" cutting");
    }

    public void box(){
        System.out.println(name+" boxing");
    }

    public void setName(String name) {
        this.name = name;
    }
}
