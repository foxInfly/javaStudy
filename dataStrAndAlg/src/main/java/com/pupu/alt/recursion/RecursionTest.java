package com.pupu.alt.recursion;

/**递归
 * @author : lipu
 * @since : 2020-02-21 22:36
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        System.out.println(factorial(3));
    }

    //打印问题
    public static void test(int n){
        if (n > 2) {
            test(n-1);
        }
        System.out.println("n = "+n);
    }

    //阶乘问题
    public static int factorial(int n){
        if (n == 1) {
            return 1;
        }else {
            return factorial(n-1)*n;
        }
    }
}
