package com.haobai.leetcode.dynamicProgramming;

/**
 * @author haobai
 * @description: 122. 买卖股票的最佳时机 II
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * @date 2021/2/25 17:28
 */
public class 买卖股票的最佳时机II {

    /**
     * 使用贪心算法，每次比前面大就卖出，能赚一点是一点
     * 贪心算法是特殊的动态规划问题
     *
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] > prices[i - 1]) {
//                max += prices[i] - prices[i - 1];
//            }
//        }
//        return max;
//    }

    /**
     * 动态规划的dp数组
     * dp[][]  前一个表示的是第几天    后一个  0表示这天没有持有股票  1表示这天持有了股票
     * 里面的值就是最后的收益
     * <p>
     * - 今天无持有 有两种情况 1、昨天就没有持有  2、昨天持有了但今天卖出了
     * - 今天持有 有两种情况 1、昨天就持有了 2、昨天没持有但今天买入了
     * 都要去最大收益值
     * 最后的  dp[prices.length -1][0]   计算最后一天没有持有时的最大收益
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }


}
