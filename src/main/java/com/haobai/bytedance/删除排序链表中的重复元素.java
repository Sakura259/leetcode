package com.haobai.bytedance;

import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/4/20 20:29
 */
public class 删除排序链表中的重复元素 {

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
     * 使用快慢指针进行判断前后是否相同
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) {
                break;
            }
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast = slow;
            } else {
                slow = fast;
            }
        }
        return head;
    }
}
