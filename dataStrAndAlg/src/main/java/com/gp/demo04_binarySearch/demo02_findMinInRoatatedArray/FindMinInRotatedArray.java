package com.gp.demo04_binarySearch.demo02_findMinInRoatatedArray;

/**
 * 在旋转有序数组中找最小
 *
 * @author lp
 * @since 2021/1/22 16:35
 **/
public class FindMinInRotatedArray {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]) {
                if (nums[end] <= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }
        System.out.println("start: " + start + ", end: " + end);
        return Math.min(nums[start], nums[end]);
    }

    public static void main(String[] args) {
//        int[] num = {6, 7, 8, 9, 1, 2, 3, 4, 5, 6};
        int[] num = {4, 5, 6, 7, 8, 0, 1, 2, 3};
        System.out.println(new FindMinInRotatedArray().findMin(num));
    }
}
