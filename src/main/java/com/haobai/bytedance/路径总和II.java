package com.haobai.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 23:33
 */
public class 路径总和II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }
        backTrack(root, targetSum);
        return result;
    }

    /**
     * 采用回溯法 （其实也算是DFS深度优先遍历）
     *
     * @param root
     * @param targetSum
     */
    private void backTrack(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        backTrack(root.left, targetSum);
        backTrack(root.right, targetSum);
        path.remove(path.size() - 1);
    }
}
