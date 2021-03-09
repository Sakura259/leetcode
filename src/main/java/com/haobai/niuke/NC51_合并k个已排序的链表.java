package com.haobai.niuke;

import java.util.ArrayList;

/**
 * @author haobai
 * @description:
 * @date 2021/3/2 10:05
 */
public class NC51_合并k个已排序的链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(node);
        list.add(node1);
        ListNode node2 = new NC51_合并k个已排序的链表().mergeKLists(list);
        System.out.println(node2);
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return merger(lists, 0, lists.size() - 1);
    }

    private ListNode merger(ArrayList<ListNode> lists, Integer left, Integer right) {
        if (right.equals(left)) {
            return lists.get(left);
        }
        if (right < left) {
            return null;
        }
        Integer mid = (left + right) / 2;
        return mergerTwoList(merger(lists, left, mid), merger(lists, mid + 1, right));
    }


    private ListNode mergerTwoList(ListNode left, ListNode right) {
        if (left == null || right == null) {
            return left == null ? right : left;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = left == null ? right : left;
        return head.next;
    }
}
