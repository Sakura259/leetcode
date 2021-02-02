package com.haobai.leetcode.tree;

/**
 * @author haobai
 * @description:  538 | 1038. 把二叉搜索树转换为累加树
 * @date 2020-11-28 19:55
 */
public class 把二叉搜索树转换为累加树 {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        sum += root.val;
        root.val = sum;
        inOrder(root.left);
    }

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
}
