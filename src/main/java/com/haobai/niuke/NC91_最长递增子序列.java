package com.haobai.niuke;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/3/7 16:49
 */
public class NC91_最长递增子序列 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] lis = new NC91_最长递增子序列().LIS(arr);
        System.out.println(Arrays.toString(lis));
    }

    /**
     * 采用动态规划的方式实现，时间复杂度为 O(n的平方)
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
//    public int[] LIS(int[] arr) {
//        int length = arr.length;
//        int[] dp = new int[length];
//        Arrays.fill(dp, 1);
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (arr[i] > arr[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            max = Math.max(dp[i], max);
//        }
//        int[] res = new int[max];
//        for (int i = length - 1; i >= 0; i--) {
//            if (dp[i] == max) {
//                res[--max] = arr[i];
//            }
//        }
//        return res;
//    }

    /**
     * 采用二分查找 + 贪心的方式来实现， 时间复杂度为 O(n * Log n)
     * 二分查找主要是找到第一个比这个数大的值，进行替换
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS(int[] arr) {
        int length = arr.length;
        int[] dp = new int[length];
        int[] end = new int[length + 1];
        dp[0] = 1;
        int index = 1;
        end[index] = arr[0];
        for (int i = 0; i < length; i++) {
            if (arr[i] > end[index]) {
                end[++index] = arr[i];
                dp[i] = index;
            } else {
                int left = 0, right = index;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (end[mid] >= arr[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                end[left] = arr[i];
                dp[i] = left;
            }
        }
        int[] res = new int[index];
        for (int i = length - 1; i >= 0; i--) {
            if (dp[i] == index) {
                res[--index] = arr[i];
            }
        }
        return res;
    }
}
