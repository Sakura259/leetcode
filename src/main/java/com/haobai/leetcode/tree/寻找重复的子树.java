package com.haobai.leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haobai
 * @description:  652. 寻找重复的子树
 *示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 *
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 *
 * @date 2020-11-27 14:08
 */
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        return postTraversal(root);
    }

    private List<TreeNode> postTraversal(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> resultList = new ArrayList<>(10);
        traverse(root, map, resultList);
        return new ArrayList<>(resultList);
    }

    private String traverse(TreeNode root, Map<String, Integer> map, List<TreeNode> resultList) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left, map, resultList);
        String right = traverse(root.right, map, resultList);
        String subTree = left + "," + right + "," + root.val;
        Integer orDefault = map.getOrDefault(subTree, 0);
        if (orDefault == 1) {
            resultList.add(root);
        }
        map.put(subTree, orDefault + 1);
        return subTree;
    }


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
}
