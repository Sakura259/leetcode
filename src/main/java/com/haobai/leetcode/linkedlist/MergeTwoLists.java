package com.haobai.leetcode.linkedlist;

/**
 * @author haobai
 * @description: 剑指 Offer 25. 合并两个排序的链表
 * 通过定义返回列表的头尾节点 head 和 tail 来实现
 * @date 2020-12-01 23:03
 */
public class MergeTwoLists {

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

        ListNode(int x) {
            val = x;
        }
    }
}
