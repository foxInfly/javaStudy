package com.pupu.designPattern.singleton;

/**(1) 饿汉式( 静态常量)
 * @author : lipu
 * @since : 2020-03-06 11:23
 */
public class Singleton01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance.equals(instance1));
    }
}

/**(1) 饿汉式( 静态常量)
 * @author lipu
 * @since  2020/3/6 11:24
 */
class Singleton{
    //1.构造器私有化 (防止 new )
    private Singleton(){}
    //2.类的内部创建对象
    private final static Singleton instance = new Singleton();
    //3.向外暴露一个静态的公共方法。
    public static Singleton getInstance(){
        return instance;
    }
}