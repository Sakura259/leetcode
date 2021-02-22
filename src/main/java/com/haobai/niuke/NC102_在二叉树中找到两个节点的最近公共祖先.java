package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 16:12
 */
public class NC102_在二叉树中找到两个节点的最近公共祖先 {


    public class TreeNode {
        int val = 0;

        TreeNode left = null;
        TreeNode right = null;
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        if (root == null) {
            return -1;
        }
        if (o1 == root.val || o2 == root.val) {
            return root.val;
        }
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
        // 都在右侧
        if (left == -1) {
            return right;
        }
        // 都在左侧
        if (right == -1) {
            return left;
        }
        // 在两侧
        return root.val;
    }

}
