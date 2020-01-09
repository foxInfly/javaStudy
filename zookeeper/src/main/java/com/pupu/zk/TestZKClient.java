package com.pupu.zk;

import org.apache.zookeeper.*;

/**
 * @author : lipu
 * @since : 2020-01-05 21:56
 */
public class TestZKClient {


    public static void main(String[] args) throws Exception{
        /** connectString ；集群地址；
         *  sessionTimeout：回话超时时间，默认30秒
         *  watcher：监听器
        */
        ZooKeeper zk = new ZooKeeper("zookeeper01:2181,zookeeper02:2181,zookeeper03:2181", 30000, new Watcher() {
            //事件通知的回调函数
            public void process(WatchedEvent event) {
                System.out.println(event.getState());
                System.out.println(event.getType());
                System.out.println(event.getPath());
                System.out.println(event.toString());
                System.out.println("测试git");
            }
        });
        //存咋的节点不可以再创建
//        zk.create("/myGirls","中国风".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //相当于对节点/myGirls设置了数据变化的监听，一旦节点数据改变，监听就会触发
        zk.getData("/myGirls",true,null);

        //对节点数据进行修改。触发监听。-1表示版本交给系统自己维护
        zk.setData("/myGirls","创新高地".getBytes(),-1);

        zk.close();
    }
}
