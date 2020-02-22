package com.pupu.alt.sort;

import java.util.Arrays;

/**希尔排序，从小到大
 * @author : lipu
 * @since : 2020-02-22 20:23
 */
public class ShellSort {
    public static void main(String[] args) {
//        int arr[] = {8,9,1,7,2,3,5,4,6,0};
        int arr[] = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);//[0-8000000)的数
        }
//        System.out.println("排序前的结果为："+ Arrays.toString(arr));
        long start = System.currentTimeMillis();
        int[] newArr = selectSort2(arr);
        long time = System.currentTimeMillis() - start;
        if (time>=10000) {
            System.out.println("冒泡排序耗时："+(time/1000)+"秒");
        }else {
            System.out.println("冒泡排序耗时："+time+"毫秒");
        }
//        System.out.println("排序后的结果为："+Arrays.toString(newArr));
    }

    //希尔排序(替换)，从小到大
    public static int[] selectSort(int[] arr){
        int temp = 0;
        for (int grap = arr.length/2; grap > 0 ; grap /=2) {
            for (int i = grap; i < arr.length; i++) {
                for (int j = i - grap; j >= 0 ; j -= grap) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j+grap]) {
                        temp = arr[j];
                        arr[j] = arr[j + grap];
                        arr[j+grap] = temp;
                    }
                }
            }
        }
        return arr;
    }

    //希尔排序优化(移位)，从小到大
    public static int[] selectSort2(int[] arr){
        for (int grap = arr.length/2; grap > 0 ; grap /=2) {
            for (int i = grap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - grap]) {
                    while (j - grap >= 0 && temp < arr[j - grap]){
                        arr[j] = arr[j-grap];
                        j -=grap;
                    }
                        arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
