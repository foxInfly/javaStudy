package com.pupu.zk;

import org.apache.zookeeper.*;

/**
 * @author : lipu
 * @since : 2020-01-05 21:56
 */
public class TestZKClient {

    public static void main(String[] args) throws Exception{

        /* 1.创建Zookeeper主类，用于节点的操作
         * @param  connectString  Zookeeper集群地址
         * @param  sessionTimeout 回调超时时间，默认30秒
         * @param  watcher     监听器
         */
        ZooKeeper zk = new ZooKeeper("zookeeper01:2181,zookeeper02:2181,zookeeper03:2181", 30000, new Watcher() {
            //事件通知的回调函数
            public void process(WatchedEvent event) {
                System.out.println("事件状态"+event.getState());
                System.out.println("事件类型"+event.getType());
                System.out.println("节点路径"+event.getPath());
                System.out.println("监听发生的变动内容"+event.toString());
            }
        });

        /*2.创建节点（存在的节点不可以再创建）
         * @author lipu
         * @since  2020/2/13 14:39
         * @param  path 节点路径
         * @param  bytes[] 节点数据的bytes数组
         * @param  acl 节点权限控制
         * @param  createModel 创建的节点类型（永久，临时，序列化）
        */
//        zk.create("/qiongqiong","创建琼琼节点！".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println("创建节点成功！！！！");

        /* 3.添加监听，相当于对节点/myGirls设置了数据变化的监听，一旦节点数据改变，监听就会触发
         * @author lipu
         * @since  2020/2/13 14:47
         * @param  path 节点路径
         * @param  watch 节点监听，true是添加监听
         * @param  stat 节点路径
        */
        System.out.println("===================开始设置监听==============");
        zk.getData("/qiongqiong",true,null);
        System.out.println("设置监听器成功！！！！");

        /* 4.更改有监听节点的数据，触发监听，相当于对节点/myGirls设置了数据变化的监听，一旦节点数据改变，监听就会触发
         * @author lipu
         * @since  2020/2/13 14:47
         * @param  path 节点路径
         * @param  watch 节点监听，true是添加监听
         * @param  stat 节点路径
         */
        System.out.println("===================开始修改节点数据==============");
        zk.setData("/qiongqiong","将琼琼的数据更改为：你数据第2次修改了".getBytes(),-1);
        System.out.println("修改节点数据！！！！");

        zk.close();
    }
}
