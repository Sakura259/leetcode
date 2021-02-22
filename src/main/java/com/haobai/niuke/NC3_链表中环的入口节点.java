package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 13:53
 */
public class NC3_链表中环的入口节点 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * fast 指针 = a + b + n *(b + c)
     * slow 指针 = a + b
     * 2*(a + b) = a + b + n *(b + c)
     * a = c
     * 因此，当两个指针相等时，说明存在链表环
     * 另起一个指针从开头，和slow一样的速度从相遇位置开始运动。当相遇时，就是链表环的入口
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 说明存在链表环
            if (slow == fast) {
                // a = c
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
