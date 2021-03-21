package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 10:15
 */
public class 买卖股票的最佳时机 {

    /**
     * 每次获取最小的那个值，判断当前值与最小值的差值是否是最大的
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = prices[0], max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
