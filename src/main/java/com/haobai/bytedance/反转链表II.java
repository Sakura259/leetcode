package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/4/2 14:58
 */
public class 反转链表II {

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

    /**
     * 采用头插法的反转链表
     * 记录要反转前的节点作为头结点。每次节点都插到这
     * <p>
     * next = cur.next;  得到下一个节点
     * cur.next = next.next;
     * next.next = pre.next;
     * pre.next = next;
     * 这三步实现了三个节点的顺序转换
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode lHead = new ListNode(-1);
        lHead.next = head;
        ListNode pre = lHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return lHead.next;
    }
}
