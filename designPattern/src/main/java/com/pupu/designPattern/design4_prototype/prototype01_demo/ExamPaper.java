package com.pupu.designPattern.design4_prototype.prototype01_demo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ExamPaper{
    private int age;
    private String name;
    private List<String> hobbies;

   public ExamPaper copy(){
      ExamPaper examPaper = new ExamPaper();
      //剩余时间
      examPaper.setAge(this.getAge());
      //单位主键
      examPaper.setName(this.getName());
      //考试主键
       examPaper.setHobbies(this.getHobbies());

      return examPaper;
   }
}