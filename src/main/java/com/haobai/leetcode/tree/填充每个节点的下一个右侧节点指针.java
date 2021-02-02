package com.haobai.leetcode.tree;

/**
 * @author haobai
 * @description: 116. 填充每个节点的下一个右侧节点指针
 * @date 2020-11-25 15:56
 */
public class 填充每个节点的下一个右侧节点指针 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        twoConnect(root.left, root.right);
        return root;
    }

    private void twoConnect(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        node1.next = node2;
        twoConnect(node1.left, node1.right);
        twoConnect(node2.left, node2.right);
        twoConnect(node1.right, node2.left);
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
