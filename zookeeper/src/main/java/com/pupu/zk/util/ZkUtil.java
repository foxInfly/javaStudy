package com.pupu.zk.util;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author : lipu
 * @since : 2020-02-13 15:05
 */
public class ZkUtil {

    /**1.创建节点（存在的节点不可以再创建）
     * @author lipu
     * @since  2020/2/13 15:15
     * @param  path 节点路径
     * @param  date 节点数据的bytes数组
     * @param  acl 节点权限控制
     * @param  createMode 创建的节点类型（永久，临时，序列化）
    */
    public static void ctreate(String path, byte[] date, List<ACL> acl, CreateMode createMode, ZooKeeper zk){
        try {
            System.out.println("===================开始创建:"+path+" 节点================");
            zk.create(path,date,acl,createMode);
            System.out.println("===================创建:"+path+" 节点成功================");
        } catch (Exception e) {
            System.out.println("******************创建:"+path+" 节失败功******************");
            e.printStackTrace();
        }
    }

    /** 2.添加监听，相当于对节点/myGirls设置了数据变化的监听，一旦节点数据改变，监听就会触发
     * @author lipu
     * @since  2020/2/13 14:47
     * @param  path 节点路径
     * @param  watcher 节点监听，true是添加监听
     * @param  stat 节点状态
     */
    public static void getData(String path, Boolean watcher, Stat stat, ZooKeeper zk){
        try {
            System.out.println("===================开始添加节点:"+path+" 的监听================");
            zk.getData(path,watcher,stat);
            System.out.println("===================添加节点:"+path+" 的监听成功================");
        } catch (Exception e) {
            System.out.println("******************添加节点:"+path+" 的监听败功******************");
            e.printStackTrace();
        }
    }

    /**3.修改节点数据，触发监听，相当于对节点设置了数据变化的监听，一旦节点数据改变，监听就会触发
     * @author lipu
     * @since  2020/2/13 15:15
     * @param  path 节点路径
     * @param  date 节点数据的bytes数组
     * @param  version 节点包版本，-1最新的版本
     */
    public static void setData(String path, byte[] date, int version, ZooKeeper zk){
        try {
            System.out.println("===================开始修改:"+path+" 节点================");
            zk.setData(path,date,version);
            System.out.println("===================修改:"+path+" 节点成功================");
        } catch (Exception e) {
            System.out.println("******************修改:"+path+" 节失败功******************");
            e.printStackTrace();
        }
    }

    /**3.删除节点
     * @author lipu
     * @since  2020/2/13 15:15
     * @param  path 节点路径
     * @param  version 节点包版本，-1最新的版本
     */
    public static void delete(String path, int version, ZooKeeper zk){
        try {
            System.out.println("===================开始删除:"+path+" 节点================");
            zk.delete(path,-1);
            System.out.println("===================删除:"+path+" 节点成功================");
        } catch (Exception e) {
            System.out.println("******************删除:"+path+" 节失败功******************");
            e.printStackTrace();
        }
    }
}
