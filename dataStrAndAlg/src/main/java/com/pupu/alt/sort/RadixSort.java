package com.pupu.alt.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 基数排序
 *  基数排序是使用空间换时间的经典算法
 * @author : lipu
 * @since : 2020-02-22 23:54
 */
public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
//        int[] arr = GenericArrUtil.genericArr(80000);
        System.out.println("排序前的结果为：" + Arrays.toString(arr));
        long start = System.currentTimeMillis();

        radixSort(arr);

        long time = System.currentTimeMillis() - start;
        System.out.println("基数排序耗时：" + (System.currentTimeMillis() - start) + "毫秒");
        System.out.println("排序后的结果为：" + Arrays.toString(arr));

    }

    //基数排序方法
    public static void radixSort(int[] arr) {
        //1.得到数组中最大的数的位数
        int max = arr[0];//假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //如果最小值是负数，应该全部加上一个数，处理成非负数

        //2.得到最大数是几位,判断有几轮
        int maxLength = (max + "").length();

        //3.定义一个二维数组，表示10个桶，每个桶是一个一维数组；为了防止在放入数的时候，数据溢出，则每个一维数组（桶），大小定位arr.length
        int[][] bucket = new int[10][arr.length];

        //4.为记录每个桶中，存放了少个数据，定义一个一维数组，记录各个桶的每次放入的数据个数
        //比如：bucketElementCounts[0]，记录的就是bucket[0]桶的放入数的个数，一开始0递增
        int[] bucketElementCounts = new int[10];

        /*
         * n是位数
         */
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //针对每个说的位数进行排序，依次是个十百千万。。。
            for (int j = 0; j < arr.length; j++) {
                //取出每个符合条件元素的值
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序，一维数组的下标依次取出数据，放入原来数组）
            int index = 0;
            //遍历每一个桶，并将桶中的数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第k个桶（即第k个一维数组），放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第i+1轮处理后，需要将bucketElementCounts[k]重置为0，就是每个桶人为他们没数据了，根据bucketElementCounts[k]去取值，妙呀
                bucketElementCounts[k] = 0;
            }
//            System.out.println("第"+(i+1)+"轮处理后的排序处理 arr=" + Arrays.toString(arr));
        }
    }
}
