package com.haobai.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 10:54
 */
public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
