package com.pupu.designPattern.singleton;

/**(7) 静态内部类
 * @author : lipu
 * @since : 2020-07-07 11:27
 */
public class Singleton07 {
    public static void main(String[] args) {
        Singleton7 instance = Singleton7.getInstance();
        Singleton7 instance1 = Singleton7.getInstance();
        System.out.println(instance.equals(instance1));
    }
}

/**(7) 静态内部类
 * @author lipu
 * @since  2020/7/7 11:27
 */
class Singleton7{
    private Singleton7(){}

    private static class SingletonInstance{
        private static volatile Singleton7 instance = new Singleton7();
    }

    //7.向外暴露一个静态的公共方法。
    public static  Singleton7 getInstance(){
        return SingletonInstance.instance;
    }
}