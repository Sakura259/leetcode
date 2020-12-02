package com.haobai.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2020-11-25 17:52
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(10);
        inOrderTraversal(list, root);
        return list;
    }

    private void inOrderTraversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(list, node.left);
        list.add(node.val);
        inOrderTraversal(list, node.right);
    }

    private class TreeNode {
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
