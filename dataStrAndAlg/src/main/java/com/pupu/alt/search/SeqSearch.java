package com.pupu.alt.search;

/**顺序查找
 * @author : lipu
 * @since : 2020-02-23 13:39
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1,8, 10, 89, 1000, 1234};
        int i = seqSearch(arr, 10);
        if (i == -1) {
            System.out.println("没有找到对应的值");
        }else {
            System.out.println("找到对应的值,下标为："+i);
        }
    }

    public static int seqSearch(int[] arr, int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
