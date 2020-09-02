package com.pupu.designPattern.design2_singleton.singleton4_synchronized_block_lazy;

/**
 * 懒汉-静态代码块
 *     1.私有化构造器
 *     2.私有化创建内部类对象
 *     3.暴露一个获取私有化内部类对象的公共方法
 * 优点：
 *     解决了 线程安全问题
 * 缺点：
 *     高并发会触发多次new
 * 适用场景：
 *    不推荐使用（没人用这种）
 *
 * @author lipu
 * @since 2020-09-02 10:14:33
 */
public class Car {

    private Car() {
    }

    private static Car instance;

    public static  Car getInstance() {
        if (instance == null) {
            synchronized(Car.class){
                instance = new Car();
            }

        }
        return instance;
    }

}
