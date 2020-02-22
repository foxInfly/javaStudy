package com.pupu.alt.sort;

import java.util.Arrays;

/**插入排序，由小到大
 * @author : lipu
 * @since : 2020-02-22 19:40
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = new int[80000];
//        int arr[] = {3,9,-1,10,20};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);//[0-8000000)的数
        }
        System.out.println("排序前的结果为："+ Arrays.toString(arr));
        long start = System.currentTimeMillis();
        int[] newArr = selectSort(arr);
        long time = System.currentTimeMillis() - start;
        if (time>=10000) {
            System.out.println("冒泡排序耗时："+(time/1000)+"秒");
        }else {
            System.out.println("冒泡排序耗时："+time+"毫秒");
        }
        System.out.println("排序后的结果为："+Arrays.toString(newArr));

    }


    //插入排序，由小到大
    public static int[] selectSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertVal = arr[i];
            int insertIndex = i - 1;//即arr[1]的前一个数的下标
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex +1 != i){
                arr[insertIndex+1] = insertVal;
            }
        }
        return arr;
    }
}
