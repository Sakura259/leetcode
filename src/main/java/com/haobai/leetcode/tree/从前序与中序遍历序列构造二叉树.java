package com.haobai.leetcode.tree;


/**
 * @author haobai
 * @description: 105. 从前序与中序遍历序列构造二叉树
 * @date 2020-11-26 17:11
 */
public class PreAndInOrderBuildTree {

    public static void main(String[] args) {
        PreAndInOrderBuildTree tree = new PreAndInOrderBuildTree();
        tree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int prePre, int prePost,
                               int[] inorder, int inPre, int inPost) {
        if (prePre > prePost || inPre > inPost) {
            return null;
        }
        int index = prePre, num = preorder[prePre];
        for (int i = inPre; i <= inPost; i++) {
            if (inorder[i] == num) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(num);
        int leftSize = index - inPre;
        root.left = buildTree(preorder, prePre + 1, leftSize + prePre, inorder, inPre, index - 1);
        root.right = buildTree(preorder, leftSize + prePre + 1, prePost, inorder, index + 1, inPost);
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }
}
