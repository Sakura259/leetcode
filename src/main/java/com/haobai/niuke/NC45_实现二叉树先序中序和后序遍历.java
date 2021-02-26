package com.haobai.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/2/20 17:51
 */
public class NC45_实现二叉树先序中序和后序遍历 {

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);

        System.out.println(Arrays.toString(new NC45_实现二叉树先序中序和后序遍历().threeOrders(root)));
    }

    public static class TreeNode {
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

    public int[][] threeOrders(TreeNode root) {
        int[][] result = new int[3][];
        List<Integer> pre = new ArrayList<>(16);
        List<Integer> in = new ArrayList<>(16);
        List<Integer> post = new ArrayList<>(16);

        preOrder(root, result, pre);
        inOrder(root, result, in);
        postOrder(root, result, post);
        result[0] = pre.stream().mapToInt(Integer::intValue).toArray();
        result[1] = in.stream().mapToInt(Integer::intValue).toArray();
        result[2] = post.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }

    private void preOrder(TreeNode root, int[][] result, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, result, list);
        preOrder(root.right, result, list);
    }

    private void inOrder(TreeNode root, int[][] result, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result, list);
        list.add(root.val);
        inOrder(root.right, result, list);
    }

    private void postOrder(TreeNode root, int[][] result, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result, list);
        postOrder(root.right, result, list);
        list.add(root.val);
    }
}
