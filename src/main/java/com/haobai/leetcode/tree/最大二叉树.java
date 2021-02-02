package com.haobai.leetcode.tree;

/**
 * @author haobai
 * @description:654. 最大二叉树
 * @date 2020-11-26 16:28
 */
public class ConstructMaximumBinaryTree {


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = left, rootVal = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] > rootVal) {
                index = i;
                rootVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);
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
