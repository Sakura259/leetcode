package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/4/14 21:01
 */
public class 单链表排序 {

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
     * 自顶向下的归并排序
     * 时间复杂度：O(n * logn)
     * 空间复杂度：O(logn)   => 由于是递归抵用，堆栈空间占用
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        // write code here
        return merge(head, null);
    }

    private ListNode merge(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return mergeTwo(merge(head, slow), merge(slow, tail));

    }

    /**
     * 合并两个有序链表
     *
     * @param head
     * @param tail
     * @return
     */
    private ListNode mergeTwo(ListNode head, ListNode tail) {
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while (head != null && tail != null) {
            if (head.val < tail.val) {
                tmp.next = head;
                head = head.next;
            } else {
                tmp.next = tail;
                tail = tail.next;
            }
            tmp = tmp.next;
        }
        tmp.next = head == null ? tail : head;
        return node.next;
    }

    /**
     * 自底而上归并排序
     * 时间复杂度:O(n * logn)
     * 空间复杂度:O(1)  不存在递归栈
     *
     * @param head
     * @return
     */
    public ListNode sortInList(ListNode head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }
        ListNode nHead = new ListNode(-1, head);
        for (int i = 1; i < len; i = i * 2) {
            ListNode pre = nHead, cur = nHead.next;
            while (cur != null) {
                ListNode h1 = cur;
                for (int j = 1; j < i && cur.next != null; j++) {
                    cur = cur.next;
                }
                ListNode h2 = cur.next;
                cur.next = null;
                cur = h2;
                for (int j = 1; j < i && cur != null && cur.next != null; j++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                ListNode node = mergeTwo(h1, h2);
                pre.next = node;
                while (pre.next != null) {
                    pre = pre.next;
                }
                cur = next;
            }
        }
        return nHead.next;
    }
}
