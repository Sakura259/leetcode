package com.test;

/**
 * @author haobai
 * @description:
 * @date 2021/3/24 15:39
 */
public class MapTest {

    static class Node {

        Integer value;

        Node next;

        public Node(Integer value) {
            this.value = value;
        }
    }

    public static Integer getMid(Node root) {
        if (root == null) {
            return 0;
        }
        Node slow = root, fast = root;
        int index = 0;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        Node root = new Node(9);
        Node node1 = new Node(5);
        Node node2 = new Node(1);
        Node node3 = new Node(4);
        Node node4 = new Node(2);
        root.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        Integer mid = MapTest.getMid(root);
        System.out.println(mid);


    }
}
