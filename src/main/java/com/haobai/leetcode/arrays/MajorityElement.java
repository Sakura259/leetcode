package com.haobai.leetcode.arrays;

/**
 * @author haobai
 * @description: Majority Element（求众数）
 * https://leetcode-cn.com/problems/majority-element/
 * @date 2020-11-24 17:20
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int count = 1, flag = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                flag = nums[i];
            }
            if (nums[i] == flag) {
                count ++;
            } else {
                count--;
            }
        }
        return flag;
    }
}
