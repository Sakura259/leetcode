package com.haobai.leetcode.back;

/**
 * @author haobai
 * @description:
 * @date 2021/2/18 21:44
 */
public class 买股票的最好时机 {

    private int max = 0;

    public static void main(String[] args) {
        System.out.println(new 买股票的最好时机().maxProfit(new int[]{1, 4, 2}));
    }

    public int maxProfit(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] > max) {
                    max = nums[j] - nums[i];
                }
            }
        }
        return max;
    }
}
