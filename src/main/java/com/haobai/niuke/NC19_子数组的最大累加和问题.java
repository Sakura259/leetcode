package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 01:04
 */
public class NC19_子数组的最大累加和问题 {

    public static void main(String[] args) {
        int[] arr = {-1, 1, 2, 3, -5};
        System.out.println(new NC19_子数组的最大累加和问题().maxSumOfSubarray(arr));
    }

    /**
     * 就是最大子旭和
     * 最大累计这些问题，就可以通过动态规划来做，动态规划统一采用自底向上的做法，定义dp数组，确定base case
     * 在这边 dp[0] = arr[0] 就是第一个数
     * 接下来来思考状态转移方程
     * dp[i] 值与dp[i-1] 区别就是加不加上arr[i],
     * 因此，得出结论。
     * dp[i] = max(dp[i-1] + arr[i], arr[i])
     * <p>
     * 一般的状态转移方程  dp[i] 一般和 dp[i-1] 有关系，无非是取最值的问题。
     * <p>
     * 注意，最大的累加和不一定在最长的子串中，需要自己去遍历dp数组，拿到最大值。
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxSumOfSubarray(int[] arr) {
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
