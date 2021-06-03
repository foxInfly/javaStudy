package com.pupu.niukeStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 取近似值  四舍五入
 *
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * @author lp
 * @since 2021/6/3 16:05:54
 */
public class Lp001_近似值 {
    public static void main(String[] args) throws IOException {
        while (true){
            System.out.print("请输入您的浮点数：");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            int index = s.indexOf(".");
            int a = Integer.parseInt(s.substring(0, index));
            int b = Integer.parseInt(s.substring(index+1,index+2));
            if (b>=5){
                System.out.println(++a);
            }else {
                System.out.println(a);
            }
//            Scanner scanner = new Scanner(System.in);
//            Double num = Double.parseDouble(s);
//            float num = scanner.nextDouble();
//            System.out.println(get(num));
        }


    }

    private static int get(Double num) {
        return (int)(num+0.5);
    }


}
