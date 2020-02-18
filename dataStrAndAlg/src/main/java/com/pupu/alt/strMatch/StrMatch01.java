package com.pupu.alt.strMatch;

import org.junit.Test;

/**字符串匹配
 * @author : lipu
 * @since : 2020-02-18 17:05
 */
public class StrMatch01 {

    String targetStr ="打死你，你奶奶写这个破暴力写了半天，打死你个丫丫丫的破CPU还那么强，不得不再打几行字，打死你个丫丫丫的破CPU还那么强，不得不再打几行字，快点学习数据结构合算吧把";
    String matchStr ="打死你个丫丫丫的破CPU还那么强，不得不再打几行字";

    //暴力匹配
    @Test
    public void matchStr(){
        long start = System.currentTimeMillis();
        char[] matchStrs = matchStr.toCharArray();
        char[] targetStrs = targetStr.toCharArray();
        System.out.println("matchStrs.length:"+matchStrs.length+";targetStr.length():"+targetStr.length());
        for (int i = 0; i < targetStrs.length-matchStrs.length; i++) {
            System.out.println("i:"+i);
            int k = i;
            for (int j = 0; j < matchStrs.length; j++) {
                System.out.println("matchStr["+j+"]:"+matchStrs[j]+";targetStr["+k+"]:"+targetStrs[k]);
                if(matchStrs[j]==targetStrs[k++]){
                    if(j==matchStrs.length-1){
                        System.out.println("匹配成功，第一次出现的位置："+(i));
                        long end = System.currentTimeMillis();
                        System.out.println("暴力匹配耗时："+(end-start));
                        return;
                    }
                }else {
                    break;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("暴力匹配耗时："+(end-start));
    }

    //KML算法
    @Test
    public void matchStrKML(){
        System.out.println((1/10)+";"+(1%10));
    }
}
