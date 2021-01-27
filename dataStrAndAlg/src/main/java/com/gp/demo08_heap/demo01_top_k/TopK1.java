package com.gp.demo08_heap.demo01_top_k;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  数组中的第K个最大元素
 * @author lp
 * @since 2021/1/27 10:58
 **/
public class TopK1 {
    public int findKthLargest(int[] nums, int k) {
        //排序
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
             public int compare(Integer num1, Integer num2) {
                 return num2 - num1;
             }
         });

         for (int i : nums) {
             maxHeap.add(i);
         }

         for (int i = 0; i < k - 1; i++) {
             maxHeap.poll();
         }
         return maxHeap.poll();
    }
}