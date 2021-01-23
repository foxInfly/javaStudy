package com.gp.demo05_twopoint.demo04_TrappingRainWater;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *  https://www.cnblogs.com/king-lps/p/10789797.html
 * @author lp
 * @since 2021/1/23 10:35
 **/
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int length = height.length;
        int left = 0;
        int right = length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        int sum = 0;
        //向最高的靠。前一个比这个矮，就会存水
        while (left < right) {
            if (leftHeight < rightHeight) {
                if (leftHeight > height[left + 1]) {
                    sum += leftHeight - height[left + 1];
                } else {
                    leftHeight = height[left + 1];
                }
                left++;
            } else {
                if (rightHeight > height[right - 1]) {
                    sum += rightHeight - height[right - 1];
                } else {
                    rightHeight = height[right - 1];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] num ={0,1,0,2,1,0,1,3,2,1,2,1};
        int i = new TrappingRainWater().trap(num);
        System.out.println(i);
    }
}