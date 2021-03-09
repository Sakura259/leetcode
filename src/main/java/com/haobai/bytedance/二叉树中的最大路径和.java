package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/5 09:59
 */
public class 二叉树中的最大路径和 {

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

    private Integer max = Integer.MIN_VALUE;

    /**
     * 使用后序遍历
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private Integer postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = Math.max(postOrder(root.left), 0);
        int rightValue = Math.max(postOrder(root.right), 0);
        max = Math.max(leftValue + rightValue + root.val, max);
        return root.val + Math.max(leftValue, rightValue);
    }
}
