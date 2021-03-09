package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/4 23:46
 */
public class 环形链表II {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode first = head;
                while (slow != first) {
                    slow = slow.next;
                    first = first.next;
                }
                return slow;
            }
        }
        return null;
    }
}
