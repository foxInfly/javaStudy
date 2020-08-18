package com.pupu.designPattern.factory.simplefactory;

/**奶酪披萨
 * @author : lipu
 * @since : 2020-03-06 14:47
 */
public class CheesePizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给奶酪披萨准备原材料。。");
    }
}
