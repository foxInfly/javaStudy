package com.pupu.alt.search;

import java.util.ArrayList;

/**二分查找，前提：数组一定是有序的
 * @author : lipu
 * @since : 2020-02-23 13:45
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,8, 10, 89, 1000,  1000,1234};
//        int i = binarySearch(arr, 0, arr.length-1, 1000);
        ArrayList<Integer> list = binarySearch2(arr, 0, arr.length-1, 1000);

        if (list.size() == 0) {
            System.out.println("二分查找没有找到对应的值");
        }else {
            System.out.println("二分查找找到对应的值,下标为："+list);
        }
    }

    /**无重复数据的有序数组
     * @author lipu
     * @since  2020/2/23 13:47
     * @param  arr 数组
     * @param  left 左边的索引
     * @param  right 右边的索引
     * @param  findVal 要查找的值
     * @return 找到的值的下标
    */
    public static int binarySearch(int[] arr, int left, int right, int findVal){
        //没查到的
        if(left>right){return -1;}

        int mid = (left+right)/2;
        int midVal = arr[mid];

        if (findVal > midVal) {//向右递归
           return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal) {//向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }

    /**有重复数据的有序数组
     * @author lipu
     * @since  2020/2/23 13:47
     * @param  arr 数组
     * @param  left 左边的索引
     * @param  right 右边的索引
     * @param  findVal 要查找的值
     * @return 找到的值的下标
     */
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        //没查到的
        if(left>right){return new ArrayList<Integer>();}
        int mid = (left+right)/2;
        int midVal = arr[mid];

        if (findVal > midVal) {//向右递归
            return binarySearch2(arr,mid+1,right,findVal);
        }else if (findVal < midVal) {//向左递归
            return binarySearch2(arr,left,mid-1,findVal);
        }else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            //向mid索引的左边扫描
            int temp = mid -1;
            while (true){
                if (temp <0 || arr[temp] != findVal){break;}//退出
                //否则，就temp放入到resIndexList
                resIndexList.add(temp);
                temp -= 1;
            }
            resIndexList.add(mid);
            //向mid索引的右边扫描
            temp = mid +1;
            while (true){
                if (temp > arr.length - 1 || arr[temp] != findVal){break;}//退出
                //否则，就temp放入到resIndexList
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }
}
