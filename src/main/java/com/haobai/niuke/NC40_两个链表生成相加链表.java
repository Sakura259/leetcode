package com.haobai.niuke;

import java.util.LinkedList;

/**
 * @author haobai
 * @description: 题目描述
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * <p>
 * 如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 * 示例1
 * <p>
 * 输入
 * [9,3,7],[6,3]
 * <p>
 * 返回值
 * {1,0,0,0}
 * @date 2021/2/25 20:49
 */
public class NC40_两个链表生成相加链表 {

    private class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        LinkedList<Integer> headStack1 = new LinkedList<>();
        LinkedList<Integer> headStack2 = new LinkedList<>();
        ListNode h1 = head1;
        ListNode h2 = head2;
        while (h1 != null) {
            headStack1.push(h1.val);
            h1 = h1.next;
        }
        while (h2 != null) {
            headStack2.push(h2.val);
            h2 = h2.next;
        }
        int c = 0;
        ListNode node = new ListNode(0);

        while (!headStack1.isEmpty() || !headStack2.isEmpty() || c != 0) {
            int stack1 = 0, stack2 = 0;
            if (!headStack1.isEmpty()) {
                stack1 = headStack1.pop();
            }
            if (!headStack2.isEmpty()) {
                stack2 = headStack2.pop();
            }
            Integer pop = stack1 + stack2 + c;
            c = pop / 10;
            ListNode listNode = new ListNode(pop % 10);
            listNode.next = node.next;
            node.next = listNode;
        }
        return node.next;
    }

    /**
     * 链表反转
     *
     * @param listNode
     * @return
     */
    private ListNode reserveList(ListNode listNode) {
        ListNode pre = null, next, cur = listNode;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
