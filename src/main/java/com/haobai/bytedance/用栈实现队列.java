package com.haobai.bytedance;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/3/4 16:58
 */
public class 用栈实现队列 {

    private LinkedList<Integer> stack = new LinkedList<>();

    private LinkedList<Integer> output = new LinkedList<>();

    /** Initialize your data structure here. */
    public 用栈实现队列() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!output.isEmpty()) {
            stack.push(output.pop());
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack.isEmpty()) {
            output.push(stack.pop());
        }
        return output.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!stack.isEmpty()) {
            output.push(stack.pop());
        }
        return output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.isEmpty() && stack.isEmpty();
    }
}
