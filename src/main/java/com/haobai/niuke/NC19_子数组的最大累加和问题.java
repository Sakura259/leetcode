package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 01:04
 */
public class NC19_子数组的最大累加和问题 {

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        System.out.println(new NC19_子数组的最大累加和问题().maxsumofSubarray(arr));
    }

    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
        }
        int result = dp[0];
        for (int i = 0; i < arr.length; i++) {
            if (result < dp[i]) {
                result = dp[i];
            }
        }
        return result;
    }
}
