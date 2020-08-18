package com.pupu.designPattern.singleton;

/**(8) 枚举
 * @author : lipu
 * @since : 2020-08-08 11:28
 */
public class Singleton08 {
    public static void main(String[] args) {
        Singleton8 instance = Singleton8.INSTANCE;
        Singleton8 instance1 = Singleton8.INSTANCE;
        System.out.println(instance.equals(instance1));
        instance.sayOk();
    }
}

/**(8) 枚举
 * @author lipu
 * @since  2020/8/8 11:28
 */
enum  Singleton8{
    INSTANCE;

    //向外暴露一个静态的公共方法。
    public void  sayOk (){
        System.out.println("OK...");
    }
}