package com.pupu.processAndThread.pessimisticLock;

import lombok.extern.slf4j.Slf4j;

/**共享问题
 * 两个线程对初始值为 0 的静态变量一个做自增，一个做自减，各做 5000 次，结果是 0 吗？
 * @author : lipu
 * @since : 2020-03-05 17:55
 */
@Slf4j(topic = "c")
public class ShareIssue {
    static int counter = 0;
    static final Object room = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room){counter++;}
            }
            log.debug("t1运算的结果：{}",counter);
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room){counter--;}
            }
            log.debug("t2运算的结果：{}",counter);
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("最终运算的结果：{}",counter);
    }
}
