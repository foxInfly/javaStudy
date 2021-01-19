package com.pupu.designPattern.design16_composite.composite02_demo.course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class CoursePackage extends CourseComponent {
    private List<CourseComponent> items = new ArrayList<CourseComponent>();
    private String name;
    private Integer level;


    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent catalogComponent) {
        items.add(catalogComponent);
    }

    @Override
    public String getName(CourseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public void removeChild(CourseComponent catalogComponent) {
        items.remove(catalogComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);

        for(CourseComponent catalogComponent : items){
            if(this.level != null){
                for(int  i = 0; i < this.level; i ++){
                    System.out.print("  ");
                }

                for(int  i = 0; i < this.level; i ++){
                    if(i == 0){ System.out.print("+"); }
                    System.out.print("-");
                }
            }
            //打印标题
            catalogComponent.print();
        }
    }

}
