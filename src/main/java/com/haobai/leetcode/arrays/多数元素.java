package com.haobai.leetcode.arrays;

/**
 * @author haobai
 * @description: 169.多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * @date 2020-11-24 17:20
 */
public class 多数元素 {

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
