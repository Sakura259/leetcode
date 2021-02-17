package com.haobai.leetcode.tree;


/**
 * @author haobai
 * @description:翻转二叉树 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 *
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * @date 2020-11-25 15:07
 */
public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode leftTemp = root.left;
        root.left = root.right;
        root.right = leftTemp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
