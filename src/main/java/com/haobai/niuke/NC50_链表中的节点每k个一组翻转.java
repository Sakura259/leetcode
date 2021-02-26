package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 13:43
 */
public class NC50_链表中的节点每k个一组翻转 {


    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        new NC50_链表中的节点每k个一组翻转().reverseKGroup(l1, 2);
    }


    /**
     * 采用递归的方式，下一次递归是从tail节点开始。
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
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
        ListNode result = reverse(head, tail);
        head.next = reverseKGroup(tail, k);
        return result;
    }

    /**
     * 反转 从head 到tail 的链表
     *
     * @param head
     * @param tail
     * @return
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = head, next;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
