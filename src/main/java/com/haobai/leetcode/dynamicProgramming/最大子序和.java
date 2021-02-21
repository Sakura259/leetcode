package com.haobai.leetcode.dynamicProgramming;

/**
 * @author haobai
 * @description: 53. 最大子序和
 * @date 2021/2/20 11:16
 */
public class 最大子序和 {

    /**
     * 思路，定义一个dp一维数组
     * 如果只有一个数字，那么最大的就是这个
     * 如果有两个数组  那么  dp[i] = max(nums[i], dp[i-1] + nums[i])
     * 只有可能是新的起点还是加上之前的结果。
     * 所以dp状态表达式就求出来了
     * 按着这个思路写就好了
     * 每个数组元素的值就是：前i个元素下的最长子序列和，最后遍历出最大的结果返回就好了
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
