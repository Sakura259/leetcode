package com.haobai.leetcode.dynamicProgramming;

/**
 * @author haobai
 * @description:
 * @date 2021/2/20 00:29
 */
public class 两个字符串的删除操作 {

    /**
     * 自底向上的dp数组
     * 两个字符串的删除操作最少是几步
     * 那不就是求出最长的公共子序列嘛
     * 然后求出每个字符串需要操作的次数，得到最少的步数
     * <p>
     * <p>
     * 因此，看到问题，不要直线思考，求最少操作次数，就是求最长的公共序列，这样操作次数才会最少！！
     * get，正反思考
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}
