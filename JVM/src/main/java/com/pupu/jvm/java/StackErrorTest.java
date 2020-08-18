package com.pupu.jvm.java;

/**测试栈的大小等
 * 默认大小count的值是11420
 * 现在设置成-Xss256k
 * count是2464
 * @author : lipu
 * @since : 2020-03-03 23:53
 */
public class StackErrorTest {

    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
