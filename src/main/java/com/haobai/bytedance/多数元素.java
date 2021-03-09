package com.haobai.bytedance;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/3/5 11:54
 */
public class 多数元素 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int midSource = nums[nums.length / 2];
        return midSource;
    }
}
