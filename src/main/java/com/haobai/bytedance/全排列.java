package com.haobai.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/3/5 15:19
 */
public class 全排列 {


    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        backTrack(path, nums);
        return res;
    }

    private void backTrack(List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backTrack(path, nums);
            path.remove(path.size() - 1);
        }
    }

}
