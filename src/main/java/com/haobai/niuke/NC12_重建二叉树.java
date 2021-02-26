package com.haobai.niuke;

/**
 * @author haobai
 * @description: 通过前序遍历和中序遍历来重建二叉树
 * @date 2021/2/22 23:20
 */
public class NC12_重建二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return buildTree(pre, 0, pre.length - 1,
                in, 0, in.length - 1);
    }

    private TreeNode buildTree(int[] pre, int preStart, int preEnd,
                               int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = pre[preStart];
        int index = preStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (val == in[i]) {
                index = i;
                break;
            }
        }
        TreeNode node = new TreeNode(val);
        int leftSize = index - inStart;
        node.left = buildTree(pre, preStart + 1, preStart + leftSize, in, inStart, index - 1);
        node.right = buildTree(pre, preStart + leftSize + 1, preEnd, in, index + 1, inEnd);
        return node;
    }

}
