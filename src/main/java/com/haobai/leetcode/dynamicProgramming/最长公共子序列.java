package com.haobai.leetcode.dynamicProgramming;

/**
 * @author haobai
 * @description: 1143. 最长公共子序列
 * <p>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 * <p>
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
