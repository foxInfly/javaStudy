package com.pupu.designPattern.singleton;

/**(2) 饿汉式（静态代码块）
 * @author : lipu
 * @since : 2020-03-06 11:23
 */
public class Singleton02 {
    public static void main(String[] args) {
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance1 = Singleton2.getInstance();
        System.out.println(instance.equals(instance1));
    }
}

/**(2) 饿汉式（静态代码块）
 * @author lipu
 * @since  2020/3/6 11:24
 */
class Singleton2{
    //1.构造器私有化 (防止 new )
    private Singleton2(){}
    //2.类的内部创建对象
    private static Singleton2 instance;
    static {instance = new Singleton2();}
    //3.向外暴露一个静态的公共方法。
    public static Singleton2 getInstance(){
        return instance;
    }
}