package com.pupu.niukeStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 求int型正整数在内存中存储时1的个数
 *
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时(二进制的形式),1的个数,有多少个1。
 * @author lp
 * @since 2021/6/3 17:00:19
 */
public class Lp002_内存中1的个数 {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        int l;
        byte[] bytes = new byte[1024];
        while ((l=in.read(bytes))>0){
            String numStr = new String(bytes, 0, l - 1);

            int num = Integer.parseInt(numStr);

            //二进制时的字符串数组010101010101
            char[] chars = Integer.toBinaryString(num).toCharArray();
            System.out.println(Arrays.toString(chars));

            int countNum = 0;
            for (char aChar : chars) {
              if (aChar == '1'){
                  countNum++;
                }
            }
            System.out.println(countNum);
        }


    }
}
