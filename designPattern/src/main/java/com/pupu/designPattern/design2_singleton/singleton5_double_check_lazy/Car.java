package com.pupu.designPattern.design2_singleton.singleton5_double_check_lazy;

/**
 * 懒汉-双重检查，对同步代码块的优化
 *     1.私有化构造器
 *     2.私有化创建内部类对象
 *     3.暴露一个获取私有化内部类对象的公共方法
 * 优点：
 *     解决了 线程安全问题
 * 缺点：
 *
 * 适用场景：
 *    延迟加载； 效率较高；推荐使用
 *
 * @author lipu
 * @since 2020-09-02 10:14:33
 */
public class Car {

    private Car() {
    }

    private static Car instance;

    public static Car getInstance() {
        if (instance == null) {
            synchronized(Car.class){
                if (instance == null) {
                    instance = new Car();
                }
            }
        }
        return instance;
    }

}
