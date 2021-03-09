package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/4 17:22
 */
public class 回文链表 {

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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head, pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null && prepre != null) {
            if (slow.val != prepre.val) {
                return false;
            }
            slow = slow.next;
            prepre = prepre.next;
        }
        return true;
    }
}
