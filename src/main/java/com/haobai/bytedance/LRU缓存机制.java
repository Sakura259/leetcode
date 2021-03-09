package com.haobai.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 17:08
 */
public class LRU缓存机制 {

    class Node {
        int key, value;
        Node next, pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();

    private Node head = new Node(-1, -1);

    private Node tail = new Node(-1, -1);

    private int capacity;

    public LRU缓存机制(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 去除当前节点，放到头结点
            Node node = map.get(key);
            node.next.pre = node.pre;
            node.pre.next = node.next;
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 判断是否存在该节点   存在会放到头结点，并更新值
        if (get(key) != -1) {
            map.get(key).value = value;
        } else {
            // 如果到达 容量，去除最后一个节点
            if (map.size() == capacity) {
                int lastKey = tail.pre.key;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                map.remove(lastKey);
            }
            // 将节点加入map并移动到链表头部
            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);
        }
    }

    private void moveToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        node.pre = head;
        head.next = node;
    }
}
