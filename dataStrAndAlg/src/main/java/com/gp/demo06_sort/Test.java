package com.gp.demo06_sort;

/**
 * @author lp
 * @since 2021-01-23 15:00:48
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {8,9,4,2,6};
//        Demo01_Bubble_Insert_Select_Sort.bubbleSort(nums);
//        Demo02_Quick_Sort.quickSort(nums);
        Demo03_Merge_sort.mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
