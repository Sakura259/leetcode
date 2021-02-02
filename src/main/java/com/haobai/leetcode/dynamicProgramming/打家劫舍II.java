package com.haobai.leetcode.dynamicProgramming;

/**
 * @author haobai
 * @description:
 * @date 2020-12-08 23:10
 */
public class 打家劫舍II {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        return Math.max(dp(nums, 0, length - 1), dp(nums, 1, length));
    }

    private int dp(int[] nums, int start, int end) {
        int dp_1 = 0, dp_2 = 0, dp = 0;
        for (int i = end - 1;i>=start;i--) {
            dp = Math.max(dp_1, dp_2 + nums[i]);
            dp_2 = dp_1;
            dp_1 = dp;
        }
        return dp;
    }
}
