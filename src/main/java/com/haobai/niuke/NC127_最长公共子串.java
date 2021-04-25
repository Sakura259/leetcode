package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 15:36
 */
public class NC127_最长公共子串 {

    public static void main(String[] args) {
        System.out.println(new NC127_最长公共子串().LCS("1A2C3D4B56", "B1D23CA45B6A"));
    }

    /**
     * 需要的是最长公共子串，是连续的
     * 采用dp数组 设置base case
     * 如果通过x来记录最后一个字符在哪，并且记录最长子串的长度  x - maxLen，x 进行字符串截取
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "-1";
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < str2.length() + 1; i++) {
            dp[0][i] = 0;
        }
        int maxLen = 0, x = 0;
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        x = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen == 0 ? "-1" : str2.substring(x - maxLen, x);
    }
}
