package com.haobai.leetcode.tree;

import java.util.LinkedList;

/**
 * @author haobai
 * @description: 297. 二叉树的序列化与反序列化
 * 采用前序遍历的方式实现序列化
 * @date 2020-11-30 17:28
 */
public class 前序实现二叉树的序列化与反序列化 {

    private String ELEMENT = "#";

    private String SEPARATE = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    private void preOrder(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append(ELEMENT).append(SEPARATE);
            return;
        }
        builder.append(root.val).append(SEPARATE);
        preOrder(root.left, builder);
        preOrder(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(",")) {
            list.add(s);
        }
        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String s = list.removeFirst();
        if (ELEMENT.equals(s)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}