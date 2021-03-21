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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode listNode = new NC78_反转链表().ReverseList(l1);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public ListNode ReverseList(ListNode head) {
        ListNode current = head;
        ListNode next;
        ListNode pre = null;
        while (current != null) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
