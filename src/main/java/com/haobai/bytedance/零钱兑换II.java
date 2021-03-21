package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/17 15:29
 */
public class 零钱兑换II {

    /**
     * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
     * <p>
     * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 外层遍历物品
        for (int coin : coins) {
            // 内层遍历背包
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
