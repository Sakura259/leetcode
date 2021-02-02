package com.haobai.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haobai
 * @description:145. 二叉树的后序遍历
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * @date 2020-11-25 17:42
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>(10);
        postOrderTraversal(list, root);
        return list;
    }

    private void postOrderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(list, root.left);
        postOrderTraversal(list, root.right);
        list.add(root.val);
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
