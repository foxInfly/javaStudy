package com.pupu.designPattern.design16_composite.composite02_demo.directory;

import java.util.ArrayList;
import java.util.List;

/**文件夹*/
public class Folder extends Directory {
    private List<Directory> dirs;

    private Integer level;

    public Folder(String name,Integer level) {
        super(name);
        this.level = level;
        this.dirs = new ArrayList<>();
    }

    @Override
    public void show() {
        System.out.println("当前目录名："+this.name);
        for (Directory dir : this.dirs) {
            if(this.level != null){
                for(int  i = 0; i < this.level; i ++){
                    System.out.print("  ");
                }

                for(int  i = 0; i < this.level; i ++){
                    if(i == 0)System.out.print("+");

                    System.out.print("-");
                }
            }
            //打印名称
            dir.show();
        }
    }

    public boolean add(Directory dir) {
        return this.dirs.add(dir);
    }

    public boolean remove(Directory dir) {
        return this.dirs.remove(dir);
    }

    public Directory get(int index) {
        return this.dirs.get(index);
    }

    public void list(){
        for (Directory dir : this.dirs) {
            System.out.println(dir.name);
        }
    }

}