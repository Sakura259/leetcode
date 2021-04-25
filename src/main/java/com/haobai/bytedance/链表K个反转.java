package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/4/14 21:00
 */
public class 链表K个反转 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode listNode = new 链表K个反转().reverseKGroup(n1, 2);


    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public void setNext(ListNode next) {
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
        ListNode cur = head, pre = head, next;
        while (cur != tail) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
