package com.haobai.leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haobai
 * @description:
 * @date 2020-12-08 23:33
 */
public class 打家劫舍III {

    private Map<TreeNode, Integer> map = new HashMap<>(16);


    public static void main(String[] args) {
        打家劫舍III x = new 打家劫舍III();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int rob = x.rob(root);
        System.out.println(rob);
    }
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int do_val = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int not_do_val = rob(root.left) + rob(root.right);
        int max = Math.max(do_val, not_do_val);
        map.put(root, max);
        return max;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
