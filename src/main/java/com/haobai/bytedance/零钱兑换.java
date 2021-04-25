package com.haobai.bytedance;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/4/20 20:02
 */
public class 零钱兑换 {

    /**
     * 采用dp数组自底向上
     * <p>
     * 1、dp数组默认置成 amount+1 表示无解
     * <p>
     * dp[i] = min(dp[i - coin] +1, dp[i])
     * 获得最少的硬币数
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
