package com.pupu.designPattern.singleton.singleton1_static_constant_hungry;

/**饿汉-静态常量
 *    1.私有化构造器
 *    2.私有化创建内部类对象
 *    3.暴露一个获取私有化内部类对象的公共方法
 *  优点：
 *     写法简单，在类装载时完成实例化。可避免线程同步问题
 *  缺点：
 *     在类装载时候完成实例化，没有达到 Lazy Loading 的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费
 *  适用场景：
 *     在类装载就必须实例化的类，如上下文，全局配置、容器等
 * @author lipu
 * @since 2020-09-02 10:14:33
 */
public class Car {

    private Car() {
    }

    private final static Car instance = new Car();

    public static Car getInstance(){return instance;};
}
