package com.haobai.leetcode.dynamicProgramming;

/**
 * @author haobai
 * @description:
 * @date 2021/2/20 00:51
 */
public class 两个字符串的最小ASCII删除和 {

    public static void main(String[] args) {
        System.out.println(new 两个字符串的最小ASCII删除和().minimumDeleteSum("sea", "eat"));
    }

    /**
     * 采用自底向上的dp数组，顺序和求最长公共子序列相反
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i + 1][s2.length()] + s1.charAt(i);
        }
        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = dp[s1.length()][j + 1] + s2.charAt(j);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + s1.charAt(i),
                            dp[i][j + 1] + s2.charAt(j));
                }
            }
        }
        return dp[0][0];
    }


}
