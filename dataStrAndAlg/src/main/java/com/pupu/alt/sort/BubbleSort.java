package com.pupu.alt.sort;

import java.util.Arrays;

/**
 * 冒泡排序,从小到大;O(n^2)
 *
 * 通过对待排序序列从前向后（从下标较小的元素开始）, 依次比较【相邻】元素的值，若发现逆序则交换，
 * 使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
 *
 * 如果一趟比较下来没有进行过交换 ， 就说明序列有序
 *
 * @author : lipu
 * @since : 2020-02-22 18:17
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = GenericArrUtil.genericArr(80000);
        System.out.println("排序前的结果为：" + Arrays.toString(arr));


        long start = System.currentTimeMillis();

        int[] newArr = bubbleSort(arr);

        long time = System.currentTimeMillis() - start;
        System.out.println("冒泡排序耗时：" + time + "毫秒");
        System.out.println("排序后的结果为：" + Arrays.toString(newArr));
    }

    public static int[] bubbleSort(int[] arr) {
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
                if (!flag) {
                    return arr;
                }
            }
        }
        return arr;
    }

}
