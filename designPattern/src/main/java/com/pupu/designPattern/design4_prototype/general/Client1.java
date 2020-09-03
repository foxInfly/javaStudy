package com.pupu.designPattern.design4_prototype.general;

import java.util.ArrayList;
import java.util.List;

/**shallow clone
 * Created by Tom.
 */
public class Client1 {


    public static void main(String[] args) throws CloneNotSupportedException {
        //创建原型对象
        ConcretePrototype1 prototype = new ConcretePrototype1();
        prototype.setAge(18);
        prototype.setName("Tom");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("run");
        hobbies.add("read");
        prototype.setHobies(hobbies);
        System.out.println("原型："+prototype);


        //拷贝原型对象
        ConcretePrototype1 cloneType = (ConcretePrototype1) prototype.clone();
        System.out.println("clone后的："+cloneType);
        System.out.println();
        System.out.println("-------开始更改colone后的对象值------");
        System.out.println();
        List<String> hobbies1 = new ArrayList<>();
        hobbies1.add("play");
        hobbies1.add("goout");
        cloneType.setAge(20);
        cloneType.setName("jack");
        cloneType.setHobies(hobbies1);
        System.out.println("clone后的："+cloneType);
        System.out.println("原型："+prototype);

    }


}
