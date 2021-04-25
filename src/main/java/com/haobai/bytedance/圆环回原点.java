package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/4/20 14:49
 */
public class 圆环回原点 {

    public Integer backToOrigin(int n) {
        int len = 10;
        int[][] dp = new int[n + 1][len];
        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = dp[i - 1][(j + 1) % len] + dp[i - 1][(j - 1 + len) % len];
            }
        }
        return dp[n][0];
    }
}
