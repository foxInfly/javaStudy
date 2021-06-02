package com.gp.demo08_heap.demo02_MedianInDataStream;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 *   数据流的中位数
 *   中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * @author lp
 * @since 2021/1/27 11:05
 **/
public class MedianInDataStream {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        int count = nums.length;
       PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(count, new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(count);
        int[] answer = new int[count];
        int number = nums[0];
        answer[0] = number;
        for (int i = 1; i < count; i++) {
            if (nums[i] > number) {
                minHeap.add(nums[i]);
            } else {
                maxHeap.add(nums[i]);
            }
            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(number);
                    number = minHeap.poll();
                } else {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            } else {
                if (maxHeap.size() - minHeap.size() == 1 && maxHeap.peek() < number) {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            }
            answer[i] = number;
        }
        return answer;
    }
    
}
