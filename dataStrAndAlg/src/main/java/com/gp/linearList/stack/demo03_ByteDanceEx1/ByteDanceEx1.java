package com.gp.linearList.stack.demo03_ByteDanceEx1;

import java.util.Stack;

/**
 * 给一个Integer数组，最小数*当前区间的和=result，求最大的result
 *
 * @author lp
 * @since 2021-01-22 09:54:04
 */
public class ByteDanceEx1 {

    public static void main(String[] args) {
        int[] numbers = {2, 6, 1};
        System.out.println(new ByteDanceEx1().getMax(numbers));
    }

    public int getMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        //
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        //求前缀和数组O(n)
        int[] sum = new int[numbers.length + 1];
        for (int i = 1; i <= numbers.length; i++) {
            sum[i] = sum[i - 1] + numbers[i - 1];
        }
        System.out.println("numbers = "+numbers[0]+", "+numbers[1]+", "+numbers[2]);
        System.out.println("sum     = "+sum[0]+", "+sum[1]+", "+sum[2]+", "+sum[3]);
        //numbers = {1, 2, 6, 1}
        //sum     = {0, 2, 8, 9}

        //numbers[i] < numbers[stack.peek()这里设计的巧妙呀，针对这个需求，这里简化成这样，人才。
        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[i] < numbers[stack.peek()]) {
                int index = stack.pop();
                int left;
                if (stack.isEmpty()) {
                    left = 0;
                } else {
                    left = index;
                }
                //用 O（1）取到前缀和
                int currentMax = numbers[index] * (sum[i] - sum[left]);
                max = Math.max(max, currentMax);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            int left;
            int right = numbers.length;
            if (stack.isEmpty()) {
                left = 0;
            } else {
                left = index;
            }
            max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
        }
        return max;
    }
}
