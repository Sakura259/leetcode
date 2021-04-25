package com.haobai.bytedance;

/**
 * @author haobai
 * @description: https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=196&tqId=37095&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-total%2Fquestion-ranking&tab=answerKey
 * @date 2021/4/14 21:01
 */
public class 两个链表找交点 {

    class ListNode {
        int val;
        ListNode next;
    }

    /**
     * 快慢指针
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
