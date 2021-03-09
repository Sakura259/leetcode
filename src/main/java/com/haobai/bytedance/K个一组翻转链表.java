package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/2 23:52
 */
public class K个一组翻转链表 {

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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        ListNode reverse = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return reverse;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = head, cur = head, next;
        while (cur != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
