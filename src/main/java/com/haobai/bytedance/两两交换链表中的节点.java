package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/4/20 22:41
 */
public class 两两交换链表中的节点 {

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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nHead = new ListNode(-1);
        nHead.next = head;
        ListNode tmp = nHead;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode n1 = tmp.next;
            ListNode n2 = tmp.next.next;
            tmp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            tmp = n1;
        }
        return nHead.next;
    }
}
