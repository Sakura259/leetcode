package com.haobai.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2020-12-08 20:47
 */
public class 打家劫舍 {

//    // 自顶向下 - 采用备忘录模式
//    private int[] memo;
//    public int rob(int[] nums) {
//        memo = new int[nums.length];
//        Arrays.fill(memo, -1);
//        return dp(nums, 0);
//    }
//
//    private int dp(int[] nums, int start) {
//        if (start > nums.length - 1) {
//            return 0;
//        }
//        if (memo[start] != -1) {
//            return memo[start];
//        }
//        int max = Math.max(nums[start] + dp(nums, start + 2), dp(nums, start + 1));
//        memo[start] = max;
//        return max;
//    }

    // 自底向上 - dp数组记录
//    public int rob(int[] nums) {
//        int length = nums.length;
//        int[] dp = new int[length + 2];
//        for (int i = length - 1; i >= 0; i--) {
//            dp[i] = Math.max(dp[i+1], dp[i + 2] + nums[i]);
//        }
//        return dp[0];
//    }
    // 自底向上的空间复杂度优化
    public int rob(int[] nums) {
        int length = nums.length;
        int dp_1 = 0, dp_2 = 0, dp = 0;
        for (int i = length - 1; i >= 0; i--) {
            dp = Math.max(dp_1, dp_2 + nums[i]);
            dp_2 = dp_1;
            dp_1 = dp;
        }
        return dp;
    }
}
