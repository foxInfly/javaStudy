package com.pupu.niukeStudy;

import java.io.*;
/**
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 *  （用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 *
 * 输入： 7 3
 * 输出： 8
 * @author lp
 * @since 2021/6/7 10:21:16
 */
public class Hw010_放苹果 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while((str = br.readLine()) != null){
            String[] s = str.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            System.out.println(count(m,n));
        }
    }
    public static int count(int m,int n){
        if(n == 1 || m == 0)return 1;
        else if(n > m)return count(m,m);
        else return count(m,n - 1) + count(m - n,n);
    }
}
