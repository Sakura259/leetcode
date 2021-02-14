package com.haobai.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haobai
 * @description:144. 二叉树的前序遍历
 * <p>
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 1-2-3
 * @date 2020-11-25 17:33
 */
public class 二叉树的前序遍历 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(10);
        preOrderTraversal(list, root);
        return list;
    }

    /**
     * 前序遍历的非递归实现
     * 通过一个栈来记录已入栈的节点
     *
     * @param list
     * @param root
     */
    private void nonRecursivePreOrder(List<Integer> list, TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                list.add(node.val);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 前序遍历的递归实现
     *
     * @param list
     * @param root
     */
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
