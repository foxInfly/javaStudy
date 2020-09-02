package com.pupu.designPattern.singleton.singleton7_enum_hungry;

/**
 * 懒汉-枚举
 *     1.私有化构造器
 *     2.私有化创建内部类对象
 *     3.暴露一个获取私有化内部类对象的公共方法
 * 优点：
 *    这借助 JDK1.5 中添加的枚举来实现单例模式。
 *    不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 * 缺点：
 *
 * 适用场景：
 *    效率较高；推荐使用
 *
 * @author lipu
 * @since 2020-09-02 10:14:33
 */
public enum  Car {
    SMALL_CAR("小汽车"),
    BIG_CAR("大汽车");
    private final String carName;
    Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }
}
