package com.pupu.alt.sort;

import java.util.Arrays;

/**
 * 冒泡排序,从小到大
 *
 * @author : lipu
 * @since : 2020-02-22 18:17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);//[0-8000000)的数
        }
        System.out.println("排序前的结果为："+Arrays.toString(arr));
        long start = System.currentTimeMillis();
        int[] newArr = bubbleSort(arr);
        long time = System.currentTimeMillis() - start;
        if (time>=10000) {
            System.out.println("冒泡排序耗时："+(time/1000)+"秒");
        }else {
            System.out.println("冒泡排序耗时："+time+"毫秒");
        }
        System.out.println("排序后的结果为："+Arrays.toString(newArr));
    }

    public static int[] bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        int temp = 0;
        boolean flag = false;//标识是否交换过
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
