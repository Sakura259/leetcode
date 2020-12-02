package com.haobai.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haobai
 * @description: 230 「二叉搜索树中第K小的元素」
 * @date 2020-11-28 19:36
 */
public class KthSmallest {


    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>(10);
        inOrder(root, list);
        return list.get(k - 1);
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
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
