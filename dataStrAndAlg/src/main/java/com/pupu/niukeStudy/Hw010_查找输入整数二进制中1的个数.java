package com.pupu.niukeStudy;

import java.io.*;
/**
 * 输入一个正整数，计算它在二进制下的1的个数。
 *
 * @author lp
 * @since 2021/6/7 10:39:20
 */
public class Hw010_查找输入整数二进制中1的个数 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            int n = Integer.parseInt(str);
            String s = Integer.toBinaryString(n);
            int cnt = 0;
            for(char c : s.toCharArray())
                if(c == '1')
                    cnt++;
            System.out.println(cnt);
        }
    }
}
