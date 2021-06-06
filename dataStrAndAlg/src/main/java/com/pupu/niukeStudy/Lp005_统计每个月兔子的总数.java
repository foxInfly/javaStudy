package com.pupu.niukeStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 斐波那切数列
 *
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 * <p>
 * 输入描述：
 * 输入int型表示month
 * <p>
 * 输出描述：
 * 输出兔子总数int型
 *
 * @author lp
 * @since 2021/6/3 20:27:24
 */
public class Lp005_统计每个月兔子的总数 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while((line = br.readLine())!= null){
            int monthCount = Integer.parseInt(line);
            System.out.println(getTotalCount(monthCount));
        }
    }

    public static int getTotalCount(int monthCount)
    {
        //斐波那锲，从第三个数开始，后面的和等于 前面的和+前前面的和
        int old = 1;
        int yang = 1;
        int count = 1;
        for(int i=2;i<monthCount;++i)
        {
            count = old + yang;
            old = yang;
            yang = count;
        }

        return count;
    }
}
