package com.pupu.designPattern.design4_prototype.prototype02_general;

/**
 * Created by Tom.
 */
public class Client {


    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge(18);
        prototype.setName("Tom");
        System.out.println("原型："+prototype);


        //拷贝原型对象
        ConcretePrototype cloneType = prototype.clone();
        System.out.println("clone后的："+cloneType);
        System.out.println();
        System.out.println("-------开始更改colone后的对象值------");
        System.out.println();
        cloneType.setAge(20);
        cloneType.setName("jack");
        System.out.println("clone后的："+cloneType);
        System.out.println("原型："+prototype);

    }


}
