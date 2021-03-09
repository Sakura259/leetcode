package com.haobai.niuke;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haobai
 * @description:
 * @date 2021/2/20 16:49
 */
public class NC93_设计LRU缓存结构1 {

    class Node {
        int key, value;
        Node next, pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    private Map<Integer, Node> map = new HashMap<>();

    private Integer k;

    public int[] LRU(int[][] operators, int k) {
        this.k = k;
        head.next = tail;
        tail.pre = head;
        int count = (int) Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                result[index ++] = get(operators[i][1]);
            }
        }
        return result;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
        } else {
            if (map.size() == k) {
                int LastKey = tail.pre.key;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                map.remove(LastKey);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);
        }

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
}
