package com.haobai.leetcode;

import java.util.HashMap;

/**
 * @author haobai
 * @description:
 * @date 2020-10-28 23:17
 */
public class twoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }
}
