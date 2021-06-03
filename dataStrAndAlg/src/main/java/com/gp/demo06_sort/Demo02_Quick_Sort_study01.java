package com.gp.demo06_sort;

import java.util.Arrays;

public class Demo02_Quick_Sort_study01 {
	
	public static void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}

    /**
     * 快速排序
     * @param array 目标数组
     * @param start 排序起始实下标
     * @param end 排序终止下标
     */
	public static void sort(int[] array, int start, int end) {
		if (start >= end)  return;

		int pivot = array[start];//作为轴的节点
		int left = start;
		int right = end;

		while (left <= right) {
			while (left <= right && pivot > array[left] )  left++;

			while (left <= right && pivot < array[right])  right--;

			if (left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}

		sort(array, start, right);
		sort(array, left, end);
	}


    public static void main(String[] args) {
        int[] array = {1,2,8,3,6,0,3,4};
            quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
