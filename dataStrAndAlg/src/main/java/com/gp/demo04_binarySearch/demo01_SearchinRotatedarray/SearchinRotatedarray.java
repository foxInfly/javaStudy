package com.gp.demo04_binarySearch.demo01_SearchinRotatedarray;

/**
 * 在旋转有序的数组中搜索
 *
 * @author lp
 * @since 2021-01-22 15:47:38
 */
public class SearchinRotatedarray {

    /**
     * 返回搜索之的下标（索引）
     *
     * @param num    有序旋转数组集合
     * @param target 要搜索的值
     */
    public int search(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }

        int start = 0;
        int end = num.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            }

            if (num[mid] > num[start]) {
                if (target <= num[mid] && num[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= num[mid] && target <= num[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
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

    public static void main(String[] args) {
//        int[] num = {6, 7, 8, 9, 1, 2, 3, 4, 5, 6};
        int[] num = {4, 5, 6, 7, 0, 1, 2, 3, 4};
        System.out.println(new SearchinRotatedarray().search(num, 6));
    }
}
