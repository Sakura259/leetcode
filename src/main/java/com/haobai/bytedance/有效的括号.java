package com.haobai.bytedance;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 16:20
 */
public class 有效的括号 {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            Character peek = stack.peek();
            if ((peek.equals('(') && s.charAt(i) == ')') ||
                    (peek.equals('[') && s.charAt(i) == ']') ||
                    (peek.equals('{') && s.charAt(i) == '}')) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
