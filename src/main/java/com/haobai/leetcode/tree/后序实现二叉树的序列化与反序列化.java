package com.haobai.leetcode.tree;


import java.util.LinkedList;

/**
 * @author haobai
 * @description: 297. 二叉树的序列化与反序列化
 * 采用后序遍历实现
 * @date 2020-11-30 22:27
 */
public class PostOrderWithSerAndDes {

    private String ELEMENT = "#";

    private String SEPARATE = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append(ELEMENT).append(SEPARATE);
            return;
        }
        serialize(root.left, builder);
        serialize(root.right, builder);
        builder.append(root.val).append(SEPARATE);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(SEPARATE)) {
            list.add(s);
        }
        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String s = list.removeLast();
        if (ELEMENT.equals(s)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.right = deserialize(list);
        root.left = deserialize(list);
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
