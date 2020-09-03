package com.pupu.designPattern.design3_builder.simple;

import lombok.Data;

/**
 * Created by Tom.
 */
@Data
public class Course {

    //course name
    private String name;
    //course ppt
    private String ppt;
    //course video
    private String video;
    //course note
    private String note;
    //course homework
    private String homework;

    @Override
    public String toString() {
        return "CourseBuilder{" +
                "name='" + name + '\'' +
                ", ppt='" + ppt + '\'' +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", homework='" + homework + '\'' +
                '}';
    }
}
