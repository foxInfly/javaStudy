package com.gp.demo05_twopoint.demo02_threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有满足条件且不重复的三元组。
 *
 * @author lp
 * @since 2021/1/23 9:42
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        //首先对数组进行排序
        Arrays.sort(numbers);
        int len = numbers.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                if (numbers[i] + numbers[left] + numbers[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    left++;
                    right--;
                    result.add(list);
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (numbers[i] + numbers[left] + numbers[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = { -1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = new ThreeSum().threeSum(num);
        System.out.println(lists);
    }
}