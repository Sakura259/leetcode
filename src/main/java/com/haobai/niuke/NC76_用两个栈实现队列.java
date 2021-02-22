package com.haobai.niuke;

import java.util.Stack;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 10:28
 */
public class NC76_用两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    /**
     * 两个栈之间的数据转移
     * 时间复杂度为 O(1)
     * 空间复杂度是 O(n)
     *
     * @param node
     */
    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
