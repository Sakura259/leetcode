package com.haobai.leetcode.back;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haobai
 * @description: 494.目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号+和-。对于数组中的任意一个整数，你都可以从+或-中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 *
 * <p>
 * 示例：
 * <p>
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 * 解释：
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * @date 2021/2/18 22:34
 */
public class 目标和 {

    private int result = 0;

    public static void main(String[] args) {
        System.out.println(new 目标和().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        // 回溯的解法
//        backTrack(0, nums, S);
//        return result;
        // 备忘录的解法
//        return dp(nums, 0, S);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        return subSets(nums, (sum + S) / 2);
    }

    /**
     * 回溯算法，先确定结束条件，再进行加选择和撤销选择
     *
     * @param i
     * @param nums
     * @param target
     */
    private void backTrack(int i, int[] nums, int target) {
        if (i == nums.length) {
            if (target == 0) {
                result++;
            }
            return;
        }
        // 先加法
        target += nums[i];
        backTrack(i + 1, nums, target);
        target -= nums[i];

        // 再减法
        target -= nums[i];
        backTrack(i + 1, nums, target);
        // 这边不用撤销，不会在进行判断了
    }

    private Map<String, Integer> memo = new HashMap<>(16);

    /**
     * 备忘录的形式来消除重叠问题
     *
     * @param nums
     * @param i
     * @param target
     * @return
     */
    private int dp(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        String key = i + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = dp(nums, i + 1, target - nums[i]) + dp(nums, i + 1, target + nums[i]);
        memo.put(key, result);
        return result;
    }

    private int subSets(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] + dp[j - nums[i - 1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[target];
    }


}
