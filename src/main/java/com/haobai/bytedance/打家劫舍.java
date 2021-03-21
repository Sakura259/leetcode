package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/17 16:10
 */
public class 打家劫舍 {


    public int rob(int[] nums) {
        int dp_1 = 0, dp_2 = 0, dp = 0;
        for (int i = 0; i < nums.length; i++) {
            dp = Math.max(dp_1, dp_2 + nums[i]);
            dp_2 = dp_1;
            dp_1 = dp;
        }
        return dp;
    }
}
