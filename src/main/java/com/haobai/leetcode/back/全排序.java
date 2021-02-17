package com.haobai.leetcode.back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haobai
 * @description: 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @date 2021/2/17 23:50
 */
public class 全排序 {

    /**
     * 采用回溯算法的框架
     * result = []
     * def backtrack(路径, 选择列表):
     *     if 满足结束条件:
     *         result.add(路径)
     *         return
     *
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径, 选择列表)
     *         撤销选择
     */
    private List<List<Integer>> list = new ArrayList<>(16);

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(track, nums);
        return list;
    }


    private void backtrack(LinkedList<Integer> track, int[] nums) {
        // base case 满足结束条件
        if (track.size() == nums.length) {
            list.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 做选择
            if (track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            // backtrack
            backtrack(track, nums);
            // 撤销选择
            track.removeLast();
        }
    }
}
