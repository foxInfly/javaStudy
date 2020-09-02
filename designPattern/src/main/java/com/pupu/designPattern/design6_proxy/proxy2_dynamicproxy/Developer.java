package com.pupu.designPattern.design6_proxy.proxy2_dynamicproxy;

/**被代理目标
 * @author lipu
 * @since 2020-09-02 15:20:46
 */
public class Developer implements Car {
    @Override
    public void buyCar() {
        System.out.println("从 开发商   买房");
    }
}
