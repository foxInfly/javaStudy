package com.pupu.niukeStudy;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * @author lp
 * @since 2021/6/3 17:46:01
 */
public class Lp003_数字颠倒 {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;

        List<String> list = new ArrayList<>();
        byte[] bytes = new byte[1024];
        int l;
        while ((l = in.read(bytes))>0){
            String numStr = new String(bytes,0, l-1);
            char[] chars = numStr.toCharArray();
            char[] charsConvert = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                charsConvert[i] = chars[chars.length-i-1];
            }
            System.out.println(new String(charsConvert));
        }

    }


}
