package com.gp.demo01_linearList.linkedList.demo04_LRUcache;

/**
 * 循环链表
 *
 * @author lp
 * @since 2021-01-21 15:42:02
 */
public class CacheNode {
    int key;
    int value;
    CacheNode prev;
    CacheNode next;
    int val;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

