package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/4/7 23:41
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int min = Integer.MIN_VALUE, index = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= min) {
                min = nums[i];
                index = i;
            } else {
                break;
            }
        }
        return index;
    }
}
