package com.pupu.processAndThread.n3;

import lombok.extern.slf4j.Slf4j;

/** 方法一，直接使用 Runnable创建线程，分3步
 * 1、创建Runnable的实现类
 * 2、通过Runnable创建Thread的实现类
 * 3、调用run方法启动实体类线程
 * @author : lipu
 * @since : 2020-03-05 14:24
 */
@Slf4j(topic = "c")
public class CreateThreadByRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> log.debug("这是一个通过Runnable创建的线程");
        Thread t = new Thread(runnable);
        t.setName("CreateThreadByRunnable");
        log.info("测试");
        t.start();
    }
}
