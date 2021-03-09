package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/3/8 09:53
 */
public class NC17_最长回文子串 {

    /**
     * 定义一个boolean类型的dp二维数组
     * for d表示头尾字符的差距
     * for i表示头字符的位置  因此  i < n -d
     * j = i + d 表示尾字符的位置
     * 只有当s.charAt(i) == s.chatAt(j)时，才进去判断
     * d = 0时，表示对角线都为true（肯定为true，自己和自己比较当然了）
     * d = 1时， 表示当前和后一个进行比较
     *
     * @param A
     * @param n
     * @return
     */
    public int getLongestPalindrome(String A, int n) {
        // write code here
        if (n == 0 || A.length() == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        boolean[][] dp = new boolean[n][n];
        for (int d = 0; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                int j = i + d;
                if (A.charAt(i) == A.charAt(j)) {
                    if (d == 0 || d == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    max = Math.max(max, d + 1);
                }
            }
        }
        return max;
    }
}
