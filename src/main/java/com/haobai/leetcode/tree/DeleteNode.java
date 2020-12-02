package com.haobai.leetcode.tree;

/**
 * @author haobai
 * @description: 450.删除二叉搜索树中的节点
 * @date 2020-11-29 23:19
 */
public class DeleteNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        deleteNode(root, 3);
        System.out.println(root);
    }


    public static TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    private static TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        int val = root.val;
        if (val > key) {
            root.left = delete(root.left, key);
        } else if (val < key) {
            root.right = delete(root.right, key);
        } else {
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            root.val = node.val;
            root.right = delete(root.right, node.val);
        }
        return root;
    }

    private static class TreeNode {
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
