package com.haobai.bytedance;


import java.util.ArrayList;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/3/31 14:52
 */
public class 重排链表 {

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

    /**
     * 采用一个list来存储所有的数据，然后进行链表拼接
     * 时间复杂度为 O(N)
     * 空间复杂度为 O(N)
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int start = 0, end = list.size() - 1;
        while (start < end) {
            list.get(start++).next = list.get(end);
            if (start > end) {
                break;
            }
            list.get(end--).next = list.get(start);
        }
        list.get(start).next = null;
    }

    /**
     * 另一个方法比较好的方法是：
     * 1、首先找到链表的中间位置  使用快慢指针
     * 2、反转后面一部分链表   使用前后指针
     * 3、将两个链表合并
     * 这样就实现了最优解
     *
     * 时间复杂度为 O(N)
     * 空间复杂度为 O(1)
     * */
}
