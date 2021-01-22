package com.gp.linearList.linkedList.demo04_LRUcache;

import java.util.HashMap;
import java.util.Map;

/**
 * Least recently used Cache
 *
 * @author lp
 * @since 2021-01-21 15:40:14
 */
public class LRUCache {

    private int capacity;//cache capacity
    private Map<Integer, CacheNode> valNodeMap = new HashMap<>();//cache
    private CacheNode head = new CacheNode(-1, -1);
    private CacheNode tail = new CacheNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        //不包含再当前缓存内
        if (!valNodeMap.containsKey(key)) {
            return -1;
        }
        //把中间的抽出来，他的前面和后面进行关联
        CacheNode current = valNodeMap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveTotail(current);
        return valNodeMap.get(key).value;

    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            valNodeMap.get(key).value = value;
            return;
        }

        if (valNodeMap.size() == capacity) {
            valNodeMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        CacheNode insert = new CacheNode(key, value);
        valNodeMap.put(key, insert);
        moveTotail(insert);
    }

    private void moveTotail(CacheNode cacheNode) {
        cacheNode.prev = tail.prev;
        tail.prev = cacheNode;
        cacheNode.prev.next = cacheNode;
        cacheNode.next = tail;
    }

    public static String listCacheNode(CacheNode head){
        StringBuilder sb = new StringBuilder();
        while (head.next != null){
            sb.append(head.val).append(" ");
            head = head.next;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        int iget1 = cache.get(1);// 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }

}
