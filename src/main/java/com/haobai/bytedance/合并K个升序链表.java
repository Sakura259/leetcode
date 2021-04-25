package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/31 15:31
 */
public class 合并K个升序链表 {

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

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    /**
     * 基于归并的思路
     *
     * @param lists
     * @param start
     * @param end
     * @return
     */
    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        return mergerTwoList(merge(lists, start, mid), merge(lists, mid + 1, end));
    }

    public ListNode mergerTwoList(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode head = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return node.next;
    }
}
