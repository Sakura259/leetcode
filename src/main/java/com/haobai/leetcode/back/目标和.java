package com.haobai.leetcode.back;

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

    public int findTargetSumWays(int[] nums, int S) {
        backTrack(0, nums, S);
        return result;
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


}
