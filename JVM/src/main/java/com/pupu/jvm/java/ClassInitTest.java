package com.pupu.jvm.java;

/**类构造器方法<clinit>()
 * prepare先给类变量赋默认值，所以代码块又可以操作了
 * @author : lipu
 * @since : 2020-03-02 09:49
 */
public class ClassInitTest {

    private static int num = 1;

    static {
        num = 2;
        number = 20;
    }
    private static int number = 10;
    public static void main(String[] args) {
        int i = 2;
        int j = 3;
        int k = i + j;

        System.out.println("k："+k);
        System.out.println("num:"+ClassInitTest.num);
        System.out.println("number:"+ClassInitTest.number);
    }

    ClassInitTest(){
        int b =1;
    }
}
