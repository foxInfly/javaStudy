package com.pupu.designPattern.factory.simplefactory;

/**希腊披萨
 * @author : lipu
 * @since : 2020-03-06 14:47
 */
public class GreekPizza extends Pizza{
    @Override
    public void prepare() {
        System.out.println("给希腊披披萨准备原材料。。");
    }
}
