package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/17 15:42
 */
public class 买卖股票的最佳时机II {

    /**
     * 采用贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
