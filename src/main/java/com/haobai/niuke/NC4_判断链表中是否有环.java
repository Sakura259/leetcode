package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/20 17:34
 */
public class NC4_判断链表中是否有环 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode l1 = head, l2 = head.next;
        while (l1 != l2) {
            if (l2 == null || l2.next == null) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next.next;
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
