package com.haobai.niuke;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/2/21 15:11
 */
public class NC15_求二叉树的层序遍历 {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * 层次遍历
     * 采用队列来做，先进先出   入队 add 出队 poll
     * 每次循环吧队列中存在的元素放进新建的数组中，需要记录循环开始是当前队列中有多少元素
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
