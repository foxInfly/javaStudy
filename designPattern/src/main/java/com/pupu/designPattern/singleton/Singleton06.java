package com.pupu.designPattern.singleton;

/**(6) 双重检查
 * @author : lipu
 * @since : 2020-06-06 11:26
 */
public class Singleton06 {
    public static void main(String[] args) {
        Singleton6 instance = Singleton6.getInstance();
        Singleton6 instance1 = Singleton6.getInstance();
        System.out.println(instance.equals(instance1));
    }
}

/**(6) 双重检查
 * @author lipu
 * @since  2020/6/6 11:26
 */
class Singleton6{
    //volatile让修改立即更新到主存，可以理解为轻量级的synchronized
    private static volatile Singleton6 instance;
    //2.构造器私有化 (防止 new )
    private Singleton6(){}
    //6.向外暴露一个静态的公共方法。
    public static  Singleton6 getInstance(){
        if (instance == null) {
            synchronized(Singleton6.class){
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}