package com.haobai.leetcode.linkedlist;

/**
 * @author haobai
 * @description: 23. 合并K个升序链表
 * 先简单求解两个有序链表的合并问题
 * 再升级为k个列表的合并
 * 通过分治法的思想，将k个链表多次合并，最终变为两个有序链表的合并
 * @date 2020-12-01 22:53
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid +1, r));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, l1ListNode = l1, l2ListNode = l2;
        while (l1ListNode != null && l2ListNode != null) {
            if (l1ListNode.val <= l2ListNode.val) {
                tail.next = l1ListNode;
                l1ListNode = l1ListNode.next;
            } else {
                tail.next = l2ListNode;
                l2ListNode = l2ListNode.next;
            }
            tail = tail.next;
        }
        tail.next = l1ListNode == null ? l2ListNode : l1ListNode;
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
