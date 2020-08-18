package com.pupu.jvm.java;

import java.io.File;

/**JVM会保证子类的<clinit>()执行前，父类的<clinit>()已经执行完毕
 * @author : lipu
 * @since : 2020-03-02 10:27
 */
public class Clinittest1 {
    static class Father{
        public static int A = 1;
        static {
            A = 3;
        }
    }

    static class Son extends Father{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);
    }
}
