package com.pupu.alt.sort;

/**
 * @author lipu
 * @since 2020-08-20 10:11:00
 */
public class GenericArrUtil {

    public static int[] genericArr(int length){
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*8000000);//[0-8000000)的数
        }

        return arr;
    }
}
