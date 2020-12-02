package com.haobai.leetcode.linkedlist;

/**
 * @author haobai
 * @description: 141. 环形链表
 * 采用快慢指针的方式：总能让快指针追上慢指针的
 * @date 2020-11-25 20:19
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
