package com.pupu.designPattern.design1_factory.simplefactory;

import java.util.Random;

/**简单工厂：
 *     优点：根据反射可以通过一个参数创建任意的对象
 *     缺点：职责过重，不易于扩展过于复杂的产品结构
 * @author : lipu
 * @since : 2020-09-01 20:29
 */
public class Test {

    public static void main(String[] args) throws Exception {
        //反射
        String[] courses = {JavaCourse.class.getName(), LinuxCourse.class.getName(), PythonCourse.class.getName()};

        int index = new Random().nextInt(courses.length);

        ICourse course = SimpleFactory.createCourse(courses[index]);

        System.out.println("我是一门 " + course.getName() + "课程");

    }
}
