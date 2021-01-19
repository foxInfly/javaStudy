package com.pupu.designPattern.design16_composite.composite02_demo.directory;

/**文件*/
public class File extends Directory {

    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }

}