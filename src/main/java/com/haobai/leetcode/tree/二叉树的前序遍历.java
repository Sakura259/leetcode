package com.haobai.leetcode.tree;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haobai
 * @description:144. 二叉树的前序遍历
 *
 * 1
 *   \
 *   2
 *  /
 * 3
 *
 *   1-2-3
 * @date 2020-11-25 17:33
 */
public class 二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(10);
        preOrderTraversal(list, root);
        return list;
    }

    private void preOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrderTraversal(list, root.left);
        preOrderTraversal(list, root.right);
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
