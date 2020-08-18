package com.pupu.designPattern.singleton;

/**(5) 懒汉式(线程安全，同步代码块)
 * @author : lipu
 * @since : 2020-05-06 11:25
 */
public class Singleton05 {
    public static void main(String[] args) {
        Singleton5 instance = Singleton5.getInstance();
        Singleton5 instance1 = Singleton5.getInstance();
        System.out.println(instance.equals(instance1));
    }
}

/**(5) 懒汉式(线程安全，同步代码块)
 * @author lipu
 * @since  2020/5/6 11:25
 */
class Singleton5{
    //1.构造器私有化 (防止 new )
    private static Singleton5 instance;
    //2.构造器私有化 (防止 new )
    private Singleton5(){}
    //5.向外暴露一个静态的公共方法。
    public static  Singleton5 getInstance(){
        if (instance == null) {
            synchronized(Singleton5.class){
                instance = new Singleton5();
            }
        }
        return instance;
    }
}