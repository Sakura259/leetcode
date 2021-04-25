package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/4/8 10:35
 */
public class 最长公共子序列 {

    public static void main(String[] args) {
        System.out.println(new 最长公共子序列().LCS("1A2C3D4B56", "B1D23CA45B6A"));
    }

    /**
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String s1, String s2) {
        // write code here
        if (s1.length() == 0 || s2.length() == 0) {
            return "-1";
        }
        String[][] res = new String[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            res[i][0] = "";
        }
        for (int i = 0; i < s2.length() + 1; i++) {
            res[0][i] = "";
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    res[i][j] = res[i][j - 1].length() > res[i - 1][j].length() ? res[i][j - 1] : res[i - 1][j];
                }
            }
        }
        if (res[s1.length()][s2.length()] == "") {
            return "-1";
        }
        return res[s1.length()][s2.length()];
    }

}
