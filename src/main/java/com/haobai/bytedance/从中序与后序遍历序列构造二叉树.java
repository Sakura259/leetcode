package com.haobai.bytedance;

/**
 * @author haobai
 * @description: 106. 从中序与后序遍历序列构造二叉树
 * @date 2020-11-26 20:33
 */
public class 从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inPre, int inPost, int[] postorder, int postPre, int postPost) {
        if (inPre > inPost || postPre > postPost) {
            return null;
        }
        int index = postPost, val = postorder[postPost];
        for (int i = inPost; i >= inPre; i--) {
            if (val == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inPre;
        TreeNode root = new TreeNode(val);
        root.left = build(inorder, inPre, index - 1, postorder, postPre, postPre + leftSize - 1);
        root.right = build(inorder, index + 1, inPost, postorder, postPre + leftSize, postPost - 1);
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
