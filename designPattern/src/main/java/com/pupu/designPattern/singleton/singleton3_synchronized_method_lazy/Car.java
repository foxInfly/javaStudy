package com.pupu.designPattern.singleton.singleton3_synchronized_method_lazy;

/**
 * 懒汉-静态方法
 *     1.私有化构造器
 *     2.私有化创建内部类对象
 *     3.暴露一个获取私有化内部类对象的公共方法
 * 优点：
 *     解决了 线程安全问题
 * 缺点：
 *     效率太低，每个线程在想获得类的实例时候，执行 getInstance()方法都要进行同步
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

    public static synchronized Car getInstance() {
        if (instance == null) {
            instance = new Car();
        }
        return instance;
    }

}
