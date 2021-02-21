package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 00:29
 */
public class NC68_跳台阶 {

    public static void main(String[] args) {
        System.out.println(new NC68_跳台阶().JumpFloor(4));
    }

    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < target + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }


}
