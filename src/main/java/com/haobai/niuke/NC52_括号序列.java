package com.haobai.niuke;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 14:36
 */
public class NC52_括号序列 {

    public static void main(String[] args) {
        System.out.println(new NC52_括号序列().isValid("([)]"));

    }

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (ch == ']') {
                boolean equals = stack.peek().equals('[');
                if (equals) {
                    stack.pop();
                }
                continue;
            }
            if (ch == '}') {
                boolean equals = stack.peek().equals('{');
                if (equals) {
                    stack.pop();
                }
                continue;
            }
            if (ch == ')') {
                boolean equals = stack.peek().equals('(');
                if (equals) {
                    stack.pop();
                }
                continue;
            }
            stack.push(ch);
        }
        return stack.isEmpty();
    }

}
