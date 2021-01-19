package com.pupu.designPattern.design16_composite.composite02_demo.directory;

/**目录
 **/
public abstract class Directory {

    /**目录名*/
    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    /**展示目录*/
    public abstract void show();

}