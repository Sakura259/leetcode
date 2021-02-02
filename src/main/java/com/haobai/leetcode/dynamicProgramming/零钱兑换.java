package com.haobai.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author haobai
 * @description: 322. 零钱兑换
 * @date 2020-12-07 23:11
 */
public class 零钱兑换 {


    public static void main(String[] args) {
        零钱兑换 x = new 零钱兑换();
        int i = x.coinChange(new int[]{1, 2, 5}, 11);

        System.out.println(i);
    }

    /**
     * 备忘录模式
     *
     * @param coins
     * @param amount
     * @return
     */
//    public int coinChange(int[] coins, int amount) {
//        return dp(coins, amount, new int[amount]);
//    }
//
//    private int dp(int[] coins, int amount, int[] count) {
//        if (amount < 0) {
//            return -1;
//        }
//        if (amount == 0) {
//            return 0;
//        }
//        if (count[amount - 1] != 0) {
//            return count[amount - 1];
//        }
//        int result = Integer.MAX_VALUE;
//        for (int coin : coins) {
//            int dp = dp(coins, amount - coin, count);
//            if (dp == -1) {
//                continue;
//            }
//            result = Math.min(result, dp + 1);
//        }
//        count[amount - 1] = result == Integer.MAX_VALUE ? -1 : result;
//        return count[amount - 1];
//    }

    /**
     * 采用 dp 数组的迭代解法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        List<Integer> list = new ArrayList<>(Collections.nCopies(amount +1, amount+1));
        list.set(0, 0);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < coins.length; j++) {
                int result = i - coins[j];
                if (result < 0) {
                    continue;
                }
                list.set(i, Math.min(list.get(i), 1 + list.get(result)));
            }
        }
        return (list.get(amount) == amount + 1) ? -1 : list.get(amount);
    }


}
