package com.gp.demo05_twopoint.demo01_twosum;


/**
 *给定一个整数升序数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数
 * @author lp
 * @since 2021/1/23 9:32
 **/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = { 1, 2, 3,5};
        int[] ints = new TwoSum().twoSum(num, 4);
        System.out.println(""+ints[0]+" "+ints[1]);
    }
}