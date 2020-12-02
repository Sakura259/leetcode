package com.haobai.leetcode.arrays;


/**
 * @author haobai
 * @description:缺失的第一个正数 https://leetcode-cn.com/problems/first-missing-positive/
 * 解题思路：仔细思考一下题目，其实可能出现的答案只能在[1, n+1];
 * 然后可以将所有小于等于0的数，变成n+1的数，不影响遍历。
 * 依次遍历数组中的每个数，将这个数对应的下标对应的值设为负数。
 * 最后做循环，返回第一个为正数的数组小标，否则就为 n+1
 * <p>
 * <p>
 * （通过hash散列的方式，用数组下标和数组正负数标记，达到了时间复杂度 O(n)和空间复杂度 O（1））
 * @date 2020-11-24 17:44
 */
public class FirstMissingPositive {


    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0 || nums[i] > len + 1) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
