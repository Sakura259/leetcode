package com.haobai.leetcode.dynamicProgramming;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author haobai
 * @description:
 * @date 2020-12-14 22:20
 */
public class 正则表达式匹配 {

    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (j == p.length()) {
            return s.length() == i;
        }
        boolean tag = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        boolean ans;
        if (j <= p.length() - 2 && p.charAt(j + 1) == '*') {
            ans = dp(i, j + 2, s, p) || (tag && dp(i + 1, j, s, p));
        } else {
            ans = tag && dp(i + 1, j + 1, s, p);
        }
        memo[i][j] = ans;
        return ans;
    }
}
