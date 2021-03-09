package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 10:15
 */
public class 买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
