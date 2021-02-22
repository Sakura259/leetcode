package com.haobai.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 16:39
 */
public class NC14_二叉树的之字形层序遍历 {

    public static void main(String[] args) {
        TreeNode t_15 = new TreeNode(15, null, null);
        TreeNode t_7 = new TreeNode(7, null, null);
        TreeNode t_9 = new TreeNode(9, t_15, t_7);
        TreeNode t_20 = new TreeNode(20, null, null);
        TreeNode t_3 = new TreeNode(3, t_9, t_20);
        System.out.println(new NC14_二叉树的之字形层序遍历().zigzagLevelOrder(t_3));
    }

    private static class TreeNode {
        int val = 0;

        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            if (flag != true) {
                Collections.reverse(list);
            }
            flag = flag ^ true;
            result.add(list);
        }
        return result;
    }
}
