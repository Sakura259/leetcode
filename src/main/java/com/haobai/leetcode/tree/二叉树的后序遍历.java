package com.haobai.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haobai
 * @description:145. 二叉树的后序遍历
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * @date 2020-11-25 17:42
 */
public class 二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(10);
        postOrderTraversal(list, root);
        return list;
    }

    /**
     * 后序遍历的递归实现
     *
     * @param list
     * @param root
     */
    private void postOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(list, root.left);
        postOrderTraversal(list, root.right);
        list.add(root.val);
    }

    /**
     * 非递归实现，采用两个栈进行记录
     *
     * @param list
     * @param root
     */
    private void postOrderTraversalWithStack(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<TreeNode> output = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                node = node.left;
            }
        }
        while (!output.isEmpty()) {
            list.add(output.pop().val);
        }
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
