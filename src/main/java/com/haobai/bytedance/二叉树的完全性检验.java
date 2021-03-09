package com.haobai.bytedance;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/3/5 00:10
 */
public class 二叉树的完全性检验 {
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

    /**
     * 当出现一个空节点之后不允许出现不为空的节点
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (flag && poll != null) {
                return false;
            }
            if (poll == null) {
                flag = true;
                continue;
            }
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return true;
    }
}
