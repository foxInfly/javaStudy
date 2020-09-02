package com.pupu.designPattern.singleton.singleton6_static_class_lazy;

/**
 * 懒汉-静态内部类
 *     1.私有化构造器
 *     2.私有化创建内部类对象
 *     3.暴露一个获取私有化内部类对象的公共方法
 * 优点：
 *     静态内部类方式在 Singleton 类被装载时并不会立即实例化,
 *     而是在需要实例化时，调用 getInstance 方法，才会装载 CarInstance 类，从而完成 Singleton 的实例化
 *     类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM 帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
 *     避免了线程不安全,实现延迟加载，效率高
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

    public static class CarInstance{
        private static volatile Car instance = new Car();
    }


    public static Car getInstance() {
        return CarInstance.instance;
    }

}
