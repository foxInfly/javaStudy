package com.pupu.processAndThread.n3;

import lombok.extern.slf4j.Slf4j;

/**测试线程交替执行； 谁先谁后，不由我们控制
 * @author : lipu
 * @since : 2020-03-05 15:07
 */
@Slf4j(topic = "c")
public class TestMultiThread {
    public static void main(String[] args) {
        new Thread(()->{
            while (true){log.debug("1running");}
        },"t1").start();

        new Thread(()->{
            while (true){log.debug("2running");}
        },"t2").start();
    }
}
