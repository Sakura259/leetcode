package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/5 15:45
 */
public class 二叉树的直径 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = dfs(root.left);
        int rightValue = dfs(root.right);
        max = Math.max(max, leftValue + rightValue);
        return Math.max(leftValue, rightValue) + 1;
    }
}
