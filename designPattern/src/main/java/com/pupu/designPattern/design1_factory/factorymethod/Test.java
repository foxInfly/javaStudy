package com.pupu.designPattern.design1_factory.factorymethod;

/**工厂方法:
 *     一个类通过其子类来指定创建哪个对象；
 *   缺点：累的个数容易过多，增加复杂度；增加系统的抽象性和理解难度；
 * @author : lipu
 * @since : 2020-09-01 22:33
 */
public class Test {
    public static void main(String[] args) {

        System.out.println(new PythonCourseFactory().create().getName());

        System.out.println(new JavaCourseFactory().create().getName());
    }
}
