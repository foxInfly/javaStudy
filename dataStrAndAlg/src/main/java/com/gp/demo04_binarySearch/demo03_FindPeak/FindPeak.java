package com.gp.demo04_binarySearch.demo03_FindPeak;


/**
 *  find peak in 旋转有序有山峰可重复数组(这里找的第一个)
 * @author lp
 * @since 2021/1/22 16:49
 **/
public class FindPeak {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        System.out.println("start:" + start + " mid:" + mid + " end:" + end);
        return nums[start] > nums[end] ? start : end;
    }

    public static void main(String[] args) {
//        int[] num = {1, 2, 4, 6, 1, 4, 6, 4, 5, 6};
        int[] num = { 1, 2, 3,1};
        System.out.println(new FindPeak().findPeakElement(num));
    }
}