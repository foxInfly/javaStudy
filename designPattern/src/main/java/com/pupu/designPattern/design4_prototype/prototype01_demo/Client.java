package com.pupu.designPattern.design4_prototype.prototype01_demo;

import java.util.ArrayList;

/**
 * Created by Tom.
 */
public class Client {
    public static void main(String[] args) {

//        ExamPaper examPaper = new ExamPaper();
//        System.out.println(examPaper);
        ExamPaper examPaper = new ExamPaper().setAge(20).setName("lp").setHobbies(new ArrayList<>());
        examPaper.getHobbies().add("看视频");
        ExamPaper examPaper1 = (ExamPaper)BeanUtils.copy(examPaper);
        System.out.println("原型："+examPaper);
        System.out.println("clone后："+examPaper1);
        System.out.println((examPaper==examPaper1)+"\n");
        System.out.println("========================================================"+"\n");

        examPaper.setAge(18).setName("qiong");
        examPaper.getHobbies().add("看书");
        System.out.println("原型："+examPaper);
        System.out.println("clone后："+examPaper1);
    }
}
