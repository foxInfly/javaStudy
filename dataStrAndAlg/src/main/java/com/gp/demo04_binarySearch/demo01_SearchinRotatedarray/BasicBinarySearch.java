package com.gp.demo04_binarySearch.demo01_SearchinRotatedarray;


/**
 * 二分法查找模板
 * 前提条件是一个有序的集合
 *
 * @author lp
 * @since 2021/1/22 15:50
 **/
public class BasicBinarySearch {
    public static void main(String[] args) {
        int[] num = {1, 4, 7, 9, 10, 14, 16, 20, 56, 89};
        System.out.println(new BasicBinarySearch().getIndex(num, 16));
    }

    /**
     * 返回搜索之的下标（索引）
     *
     * @param num    有序集合
     * @param target 要搜索的值
     */
    public int getIndex(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }

        int start = 0;//开始位置
        int end = num.length - 1;//结束位置
        int mid;//中间位置

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (num[start] == target) {
            return start;
        }
        if (num[end] == target) {
            return end;
        }
        return -1;
    }
}