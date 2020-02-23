package com.pupu.alt.search;

import java.util.Arrays;

/**斐波那锲所发
 * @author : lipu
 * @since : 2020-02-23 15:30
 */
public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int arr[] = {1,8, 10, 89, 1000,1234};
        int i = fibSearch(arr, 1);

        if (i == -1) {
            System.out.println("没有找到对应的值");
        }else {
            System.out.println("找到对应的值,下标为："+i);
        }
    }


    //生成一个斐波那契数组
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i -2];
        }
        return f;
    }

    /**递归的斐波那契
     * @author lipu
     * @since  2020/2/23 15:34
     * @param  a 数组
     * @param  key 需要查找的关键字
     * @return
    */
    public static int fibSearch(int[] a,int key){
        int low = 0;
        int high = a.length - 1;
        int k = 0;
        int mid = 0;
        int f[] = fib();
        //获取斐波那契分割数值的下标
        while (high > f[k] - 1){
            k++;
        }
        //因为f[k]的值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]，不足部分会使用0填充
        int[] temp = Arrays.copyOf(a,f[k]);

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while (low <= high){
            mid = low + f[k -1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;

                k--;
            }else if (key > temp[mid]) {
                high = mid + 1;

                k-=2;
            }else {
                if (mid <= high) {
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
