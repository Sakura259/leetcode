package com.haobai.niuke;

import java.util.ArrayList;

/**
 * @author haobai
 * @description:
 * @date 2021/3/2 11:02
 */
public class NC8_二叉树根节点到叶子节点和为指定值的路径 {


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int整型ArrayList<ArrayList <>>
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        dfs(list, root, sum);
        return result;
    }

    private void dfs(ArrayList<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                result.add(new ArrayList<>(list));
            }
        } else {
            dfs(list, root.left, sum);
            dfs(list, root.right, sum);
        }
        list.remove(list.size() - 1);
    }
}
