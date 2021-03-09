package com.haobai.bytedance;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/3/4 17:04
 */
public class 最小栈 {

    private LinkedList<Integer> stack = new LinkedList<>();

    private LinkedList<Integer> minStack = new LinkedList<>();

    /**
     * initialize your data structure here.
     */
    public 最小栈() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
