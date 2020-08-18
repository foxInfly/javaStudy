package com.pupu.designPattern.singleton;

/**(4) 懒汉式(线程安全，同步方法)
 * @author : lipu
 * @since : 2020-04-06 11:24
 */
public class Singleton04 {
    public static void main(String[] args) {
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance1 = Singleton4.getInstance();
        System.out.println(instance.equals(instance1));
    }
}

/**(4) 懒汉式(线程安全，同步方法)
 * @author lipu
 * @since  2020/4/6 11:24
 */
class Singleton4{
    //1.构造器私有化 (防止 new )
    private static Singleton4 instance;
    //2.构造器私有化 (防止 new )
    private Singleton4(){}
    //4.向外暴露一个静态的公共方法。
    public static synchronized Singleton4 getInstance(){
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}