package com.pupu.alt.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author : lipu
 * @since : 2020-02-22 21:47
 */
public class MergeSort {
    public static void main(String[] args) {
//        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] arr = GenericArrUtil.genericArr(80000);
        System.out.println("排序前的结果为：" + Arrays.toString(arr));

        long start = System.currentTimeMillis();

        int temp[] = new int[arr.length];//归并排序需要的一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);

        long time = System.currentTimeMillis() - start;
        System.out.println("归并排序耗时：" + time + "毫秒");
        System.out.println("排序后的结果为：" + Arrays.toString(arr));
    }


    //分+合方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            //到合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * 合并的方法
     *
     * @param arr   排序的原始数据
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     * @author lipu
     * @since 2020/2/22 21:50
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i，左边有序序列的初始索引
        int j = mid + 1;//初始化j，右边有序序列的初始索引
        int t = 0;//指向temp数组的第一个索引

        //一、先把左右两边（有序）的数据按照规则填充到temp数组，直到左右两边的有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {
            //如果左边有序序列的当前元素，小于等于右边有序序列的当前元素，即将左边的当前元素，填充到temp数组，然后t++  , i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {//反之，将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        //二、把剩余数据的一边的数据依次全部填充到temp
        while (i <= mid) {//左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {//右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //三、将temp数组的元素拷贝到arr，注意并不是每次都拷贝
        t = 0;
        int tempLeft = left;//
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
//        System.out.println(Arrays.toString(arr));
    }
}
