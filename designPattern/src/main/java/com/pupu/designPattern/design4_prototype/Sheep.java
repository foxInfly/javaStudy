package com.pupu.designPattern.design4_prototype;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**克隆羊
 * @author : lipu
 * @since : 2020-03-07 12:35
 */
@Slf4j
@Data
public class Sheep implements Cloneable{
    private String name;
    private int age;
    private String color;

    public Sheep(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    //重写clone()
    @Override
    protected Object clone() {
        Sheep sheep = null;

        try {
            //clone默认是浅拷贝
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("出现异常");
            e.printStackTrace();
        }
        return sheep;
    }
}
