package com.haobai.leetcode.tree;

/**
 * @author haobai
 * @description: 700. 二叉搜索树中的搜索
 * @date 2020-11-30 00:50
 */
public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else if(root.val < val) {
            return searchBST(root.right, val);
        }
        return root;
    }

    private static class TreeNode {
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
