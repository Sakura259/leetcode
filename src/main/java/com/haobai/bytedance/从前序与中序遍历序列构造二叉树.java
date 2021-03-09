package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 15:13
 */
public class 从前序与中序遍历序列构造二叉树 {

    public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int prePre, int prePost, int[] inorder, int inPre, int inPost) {
        if (prePre > prePost || inPre > inPost) {
            return null;
        }
        int tmp = preorder[prePre];
        int index = inPre;
        TreeNode root = new TreeNode(tmp);
        for (int i = inPre; i <= inPost; i++) {
            if (tmp == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - inPre;
        root.left = build(preorder, prePre + 1, prePre + leftSize, inorder, inPre, index - 1);
        root.right = build(preorder, leftSize + prePre + 1, prePost, inorder, index + 1, inPost);
        return root;
    }
}
