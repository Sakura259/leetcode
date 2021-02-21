package com.haobai.niuke;

/**
 * @author haobai
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * <p>
 * 示例1
 * 输入
 * {1,2,3}
 * <p>
 * 返回值
 * {3,2,1}
 * @date 2021/2/20 15:55
 */
public class NC78_反转链表 {

    public ListNode ReverseList(ListNode head) {
        ListNode current = head;
        ListNode next = null;
        ListNode pre = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
