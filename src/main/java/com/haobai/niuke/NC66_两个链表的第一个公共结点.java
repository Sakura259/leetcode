package com.haobai.niuke;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 22:49
 */
public class NC66_两个链表的第一个公共结点 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 双指针法
     * 时间复杂度：O(N + M)
     * 空间复杂度：O(1)
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    /**
     * 暴力解法：两次for循环进行遍历
     * 时间复杂度为 O(m*n)
     * 空间复杂度为 O(1)
     *
     * @param p1
     * @param p2
     * @return
     */
    public ListNode findFirstCommonNode1(ListNode p1, ListNode p2) {
        if (p1 == null || p2 == null) {
            return null;
        }
        ListNode cur = p1;
        while (cur != null) {
            ListNode tmp = p2;
            while (tmp != null) {
                if (tmp == cur) {
                    return cur;
                }
                tmp = tmp.next;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 采用set集合来判断
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n)
     *
     * @param p1
     * @param p2
     * @return
     */
    public ListNode findFirstCommonNode2(ListNode p1, ListNode p2) {
        if (p1 == null || p2 == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            if (set.contains(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }
}
