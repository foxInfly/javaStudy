package com.pupu.alt.sort;

import java.util.Arrays;

/**
 * 选择排序，从低到高
 *
 * @author : lipu
 * @since : 2020-02-22 19:22
 */
public class SelectSort {
    public static void main(String[] args) {
//        int arr[] = {3,9,-1,10,20};
        int[] arr = GenericArrUtil.genericArr(80000);
        System.out.println("排序前的结果为：" + Arrays.toString(arr));
        long start = System.currentTimeMillis();

        int[] newArr = selectSort(arr);

        long time = System.currentTimeMillis() - start;
        System.out.println("选择排序耗时：" + time + "毫秒");
        System.out.println("排序后的结果为：" + Arrays.toString(newArr));
    }

    //选择排序，找到当前序号的值
    public static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            //1.找最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {//说明假定的最小值不是最小值
                    min = arr[j];//重置min
                    minIndex = j;
                }
            }
            //2.最小值放第一位
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }
}
