package com.pupu.processAndThread.twoPhase;

import lombok.extern.slf4j.Slf4j;

/**两阶段终止模式
 * @author : lipu
 * @since : 2020-03-05 16:33
 */
@Slf4j(topic = "c")
public class TwoPhaseTerminationTest {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
        Thread.sleep(3500);
        tpt.stop();
    }
}

@Slf4j(topic = "c")
class TwoPhaseTermination{
    private Thread monitor;

    //启动监控线程
    public void start(){
        monitor = new Thread(()->{
            while (true){
                Thread currentThread = Thread.currentThread();
                if (currentThread.isInterrupted()) {
                    log.debug("前状态{}",currentThread.getState());
                    log.debug("被打断，开始料理后事。。");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("监控中。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //重新设置打断标记，防止sleep的时候被打断，打断标记会变成false
                    currentThread.interrupt();
                    log.debug("重新设置标记,当前状态{}",currentThread.getState());
                }
            }
        });
        monitor.start();
    }

    //停止监控线程
    public void stop(){
        monitor.interrupt();
    }
}