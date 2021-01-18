package com.pupu.designPattern.design4_prototype.prototype03_deep_shallow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom.
 */
public class Client {


    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("书法");
        hobbies.add("美术");
        prototype.setHobbies(hobbies);

        //浅clone
        ConcretePrototype shallowClone = prototype.clone();
        System.out.println("原型对象  :" + prototype);
        System.out.println("浅克隆对象:" + shallowClone);
        System.out.println((prototype == shallowClone)+"\n");

        prototype.setAge(20).setName("jack").getHobbies().add("羽毛球");
        System.out.println("原型对象  :" + prototype);
        System.out.println("浅克隆对象:" + shallowClone);
        System.out.println((prototype == shallowClone)+"\n");

        System.out.println("========================================================"+"\n");

        //拷贝原型对象
        ConcretePrototype deepClone = prototype.deepClone();
        prototype.setAge(19).setName("jery").getHobbies().add("围棋");
        System.out.println("原型对象  :" + prototype);
        System.out.println("深克隆对象:" + deepClone);
        System.out.println((prototype == deepClone)+"\n");

    }

}
