package com.gp.demo05_twopoint.demo03_ValidTriangle;

import java.util.Arrays;

/**
 * 我们一堆数字，问我们能组成多少个正确的三角形;
 *  三角形的性质:任意两条边之和要大于第三边。
 *
 * @author lp
 * @since 2021/1/23 10:28
 **/
public class ValidTriangle {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int total = 0;
        for (int k = nums.length - 1; k >= 2; k--) {
            int start = 0;
            int end = k - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[k]) {
                    total += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
        int[] num = {2, 2, 3, 4};
        int i = new ValidTriangle().triangleNumber(num);
        System.out.println(i);
    }
}