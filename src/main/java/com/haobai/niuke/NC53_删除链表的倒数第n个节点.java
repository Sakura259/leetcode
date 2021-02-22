package com.haobai.niuke;

import java.util.Queue;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 14:52
 */
public class NC53_删除链表的倒数第n个节点 {


    public class ListNode {
        int val;
        ListNode next = null;
    }


    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head, pre;
        while (n > 0) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return null;
            }
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
            if (fast == null) {
                pre.next = slow.next;
            }
        }
        return head;
    }
}
