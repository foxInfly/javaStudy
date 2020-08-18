package com.pupu.processAndThread.n3;

import lombok.extern.slf4j.Slf4j;

/** 方法一，直接使用 Thread创建线程，分两步
 * 1、创建线程Thread实体类
 * 2、调用run方法启动实体类线程
 * @author : lipu
 * @since : 2020-03-05 14:24
 */
@Slf4j(topic = "c")
public class CreateThreadByThread {
    public static void main(String[] args) {
        Thread t = new Thread(()->log.debug("这是一个通过Thread创建的线程"));
        t.setName("CreateThreadByThread");
        log.info("测试");
        t.start();
    }
}
