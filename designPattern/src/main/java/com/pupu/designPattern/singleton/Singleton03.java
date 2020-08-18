package com.pupu.designPattern.singleton;

/**(3) 懒汉式(线程不安全)
 * @author : lipu
 * @since : 2020-03-06 11:23
 */
public class Singleton03 {
    public static void main(String[] args) {
        Singleton3 instance = Singleton3.getInstance();
        Singleton3 instance1 = Singleton3.getInstance();
        System.out.println(instance.equals(instance1));
    }
}

/**(3) 懒汉式(线程不安全)
 * @author lipu
 * @since  2020/3/6 11:24
 */
class Singleton3{
    //1.构造器私有化 (防止 new )
    private static Singleton3 instance;
    //2.构造器私有化 (防止 new )
    private Singleton3(){}
    //3.向外暴露一个静态的公共方法。
    public static Singleton3 getInstance(){
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}