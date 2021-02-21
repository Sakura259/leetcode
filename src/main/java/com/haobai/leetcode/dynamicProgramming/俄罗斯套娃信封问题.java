package com.haobai.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/2/20 11:49
 */
public class 俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int i = new 俄罗斯套娃信封问题().maxEnvelopes(arr);
        System.out.println(i);
    }

    /**
     * 难点在于通过排序，把二维的问题转化为一维
     * 先对长度进行升序排序，如果长度一样，按宽度降序
     * 这样，我们只需要对宽度进行比较，由此转换为一维数组
     * 一维数组求最长递增子序列
     * <p>
     * 那么就是通过dp数组，每个字母都是1
     * 通过两个for循环，循环遍历
     * 比如算前三个数字的最长递增子序列。 那么就是 i = 2； j = 0|1进行比较，判断最长可以是多少
     * 因此 max(dp[i], dp[j] + 1)  如果j 所在数字小于 i所在位置  dp[j] +1 赋值给dp[i]，但同时要比当前的dp[i]数值大
     * 当循环遍历结束，dp数组中每个元素对应的都是前i个的最长递增子序列。
     * <p>
     * 一次for循环找出最大的递增子序列
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        int length = envelopes.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] height = new int[length];
        for (int i = 0; i < length; i++) {
            height[i] = envelopes[i][1];
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[j] < height[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;
    }
}
