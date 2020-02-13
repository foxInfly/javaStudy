package com.pupu.zk;

import com.pupu.zk.util.ZkUtil;
import org.apache.zookeeper.*;

/**
 * @author : lipu
 * @since : 2020-01-05 21:56
 */
public class TestZKClient {

    public static void main(String[] args) throws Exception{

        //Zookeeper集群地址
        //回调超时时间，默认30秒
        String connectString = "zookeeper01:2181,zookeeper02:2181,zookeeper03:2181";
        int sessionTimout=30000;

        /* 1.创建Zookeeper主类，用于节点的操作 */
        ZooKeeper zk = new ZooKeeper(connectString, sessionTimout, new Watcher() {
            //事件通知的回调函数
            public void process(WatchedEvent event) {
                System.out.println("事件状态:"+event.getState());
                System.out.println("事件类型:"+event.getType());
                System.out.println("节点路径:"+event.getPath());
                System.out.println("监听发生的变动内容:"+event.toString());
            }
        });

        String path ="/qiongqiong";
        byte[] data = "添加的节点数据".getBytes();

        ZkUtil.ctreate(path,data,ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT,zk);

        ZkUtil.getData(path,true,null,zk);

        ZkUtil.setData(path,"将琼琼的数据更改为：你数据第2次修改了".getBytes(),-1,zk);

        ZkUtil.delete(path,-1,zk);

        zk.close();
    }
}
