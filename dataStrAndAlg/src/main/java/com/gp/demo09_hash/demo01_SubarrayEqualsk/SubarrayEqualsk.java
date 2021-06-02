package com.gp.demo09_hash.demo01_SubarrayEqualsk;


import java.util.HashMap;
import java.util.Map;

/**
 *  和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * @author lp
 * @since 2021/1/27 11:20
 **/
public class SubarrayEqualsk {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int ans = 0;
        int temp = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                ans += map.get(nums[i] - k);
            }
            temp = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], temp);
        }
        return ans;
    }
}