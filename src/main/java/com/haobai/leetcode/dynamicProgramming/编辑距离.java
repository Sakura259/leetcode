package com.haobai.leetcode.dynamicProgramming;

/**
 * @author haobai
 * @description:
 * @date 2021/2/20 14:38
 */
public class 编辑距离 {

    /**
     * 编辑距离有三种  插入、删除、替换
     * 首先自底向上，初始化边界值 首先  dp[0][j] 这种其实就是需要添加多少个，因此 也是递增的。 dp[i][0] 这种就是目标字符串为空，因此需要删除原字符串，也是递增的
     * <p>
     * 初始化以后来确定状态转移函数：
     * 1、如果最后一个字符相等， 说明 dp[i][j] = dp[i-1][j-1]
     * 2、如果最后一个字符不相等，说名 dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1])
     *      dp[i-1][j] 表示添加一个字符   dp[i][j-1] 表示删除一个字符    dp[i-1][j-1] 表示替换一个字符。
     * 最后在dp[n][m] 就是字符 n转换成m所需要的最少步数。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int length = word1.length();
        int length1 = word2.length();
        if (length == 0 || length1 == 0) {
            return length + length1;
        }
        int[][] dp = new int[length + 1][length1 + 1];
        // 初始化操作
        for (int i = 0; i < length + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < length1 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < length + 1; i++) {
            for (int j = 1; j < length1 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[length][length1];
    }

}
