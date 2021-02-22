package com.haobai.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2020-12-17 19:45
 */
public class 最长递增子序列 {

    /**
     * 1、初始化边界值：当前每个元素只有1
     * 2、定义dp表达式 dp[i] = max(dp[i], dp[j] + 1)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
