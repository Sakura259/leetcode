package com.haobai.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haobai
 * @description: 中序遍历
 * @date 2020-11-25 17:52
 */
public class 二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(10);
        inOrderTraversal(list, root);
        return list;
    }

    /**
     * 非递归版本的中序遍历
     * 先将所有左子节点压入栈中。再输出当前节点，再遍历右子树
     *
     * @param list
     * @param root
     */
    private void nonRecursiveInOrder(List<Integer> list, TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
    }

    /**
     * 递归的中序遍历
     *
     * @param list
     * @param node
     */
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
