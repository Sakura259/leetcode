package com.haobai.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/2/19 23:27
 */
public class 最长公共子序列 {

    public static void main(String[] args) {
        System.out.println(new 最长公共子序列().longestCommonSubsequence("abcde", "ace"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
//        int[][] memo = new int[text1.length()][text2.length()];
//        for (int i = 0; i < text1.length(); i++) {
//            Arrays.fill(memo[i], -1);
//        }
//        return dp(text1, 0, text2, 0, memo);

        // 采用自底向上的方式来实现。首先定义出dp递归数组，明确base case，然后根据状态转移。
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // base case
        for (int i = 0; i < text2.length() + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < text1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    /**
     * 自顶向下的备忘录方式
     *
     * @param s1
     * @param i
     * @param s2
     * @param j
     * @param memo
     * @return
     */
    private int dp(String s1, int i, String s2, int j, int[][] memo) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1, memo);
        } else {
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j, memo), dp(s1, i, s2, j + 1, memo));
        }
        return memo[i][j];
    }

}
