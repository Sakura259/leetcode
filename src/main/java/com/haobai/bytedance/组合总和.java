package com.haobai.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/4/20 13:57
 */
public class 组合总和 {

    private List<List<Integer>> res = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    /**
     * 回溯搜索
     * @param candidates
     * @param target
     * @param start
     */
    private void dfs(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
