package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/17 15:17
 */
public class 两数相加 {

    private class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int c = 0;
        while (l1 != null || l2 != null || c != 0) {
            int val1 = 0, val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + c;
            c = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
        }
        return head.next;
    }
}
