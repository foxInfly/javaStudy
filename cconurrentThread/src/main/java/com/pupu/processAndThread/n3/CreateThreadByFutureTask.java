package com.pupu.processAndThread.n3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/** 方法三，使用 FutureTask创建线程，分4步
 * 1、创建FutureTask的实现类
 * 2、通过FutureTask创建Thread的实现类
 * 3、调用run方法启动实体类线程
 * 4、调用get方法获取结果
 * @author : lipu
 * @since : 2020-03-05 14:24
 */
@Slf4j(topic = "c")
public class CreateThreadByFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            log.debug("这是一个通过FutureTask创建的线程");
            return 100;
        });
        Thread t = new Thread(futureTask,"CreateThreadByFutureTask");
        log.info("测试");
        t.start();
        Integer integer = futureTask.get();
        log.info("结果是： {}",integer);
    }
}
