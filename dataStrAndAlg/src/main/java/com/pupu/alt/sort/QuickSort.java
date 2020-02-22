package com.pupu.alt.sort;

import java.util.Arrays;

/**快速排序
 * @author : lipu
 * @since : 2020-02-22 20:55
 */
public class QuickSort {
    public static void main(String[] args) {
//        int arr[] = {-9,78,0,23,-567,70};
        int arr[] = new int[800000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);//[0-8000000)的数
        }
        System.out.println("排序前的结果为："+ Arrays.toString(arr));
        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length-1);
        long time = System.currentTimeMillis() - start;
        if (time>=10000) {
            System.out.println("冒泡排序耗时："+(time/1000)+"秒");
        }else {
            System.out.println("冒泡排序耗时："+time+"毫秒");
        }
        System.out.println("排序后的结果为："+Arrays.toString(arr));
    }

    /**快速排序，从小到大
     * @author lipu
     * @since  2020/2/22 20:59
     * @param  arr 要排序的数组
     * @param  left 左下标
     * @param  right 右下标
     * @return
    */
    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];//中轴值，中间值
        int temp = 0;//临时变量，交换用
        //让比pivot小的在左边，大的在右边
        while (l < r ){
            //在pivot的在左边的左边一直找，直到大于等于pivote值，才退出
            while (arr[l] < pivot){l += 1;}
            //在pivot的在左边的左边一直找，直到小于等于pivote值，才退出
            while (arr[r] > pivot){r -= 1;}
            if (l >= r) {break;}
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[left]==pivot，right前移
            if (arr[l] == pivot) {r -=1;}
            //如果交换完后，发现这个arr[right]==pivot，left后移
            if (arr[r] == pivot) {l +=1;}
        }
        //放置栈溢出
        if (l == r) {
            l +=1;
            r -=1;
        }
        //向左递归
        if (left < r) { quickSort(arr,left,r);}
        //向右递归
        if (right > l) {quickSort(arr,l,right);}


//        return arr;
    }
}
