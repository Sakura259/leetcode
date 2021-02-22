package com.haobai.niuke;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 20:04
 */
public class NC1_大数加法 {

    public String solve(String s, String t) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = s.length() - 1, j = t.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? s.charAt(i--) - '0' : 0;
            carry += j >= 0 ? t.charAt(j--) - '0' : 0;
            stack.push(carry % 10);
            carry = carry / 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
