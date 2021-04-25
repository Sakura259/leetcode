package com.haobai.niuke;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 11:53
 */
public class 二叉树的右视图 {

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
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        TreeNode root = buildTree(xianxu, zhongxu);
        List<Integer> list = new ArrayList<>();
        dfs(list, root, 0);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(List<Integer> list, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (list.size() == depth) {
            list.add(root.val);
        }
        dfs(list, root.right, depth + 1);
        dfs(list, root.left, depth + 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
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
