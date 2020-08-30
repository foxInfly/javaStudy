package com.pupu.alt.sort;

import java.util.Arrays;

/**
 * 插入排序，由小到大
 *  n 个待排序的元素看成为一个有序表和一个无序表，开始时 有序表中只包含一个元素，无序表中包含有 n-1 个元素，
 *  排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，
 *  将它插入到有序表中的适当位置，使之成为新的有序表
 *
 * @author : lipu
 * @since : 2020-02-22 19:40
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = GenericArrUtil.genericArr(80000);
        System.out.println("排序前的结果为：" + Arrays.toString(arr));


        long start = System.currentTimeMillis();

        int[] newArr = selectSort(arr);

        long time = System.currentTimeMillis() - start;
        System.out.println("插入排序耗时：" + time + "毫秒");
        System.out.println("排序后的结果为：" + Arrays.toString(newArr));

    }


    //插入排序，由小到大
    public static int[] selectSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;//即arr[1]的前一个数的下标
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
        return arr;
    }
}
