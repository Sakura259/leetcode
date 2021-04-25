package com.haobai.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/4/20 23:03
 */
public class 子集 {

    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return res;
    }

    private void backTrack(int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
