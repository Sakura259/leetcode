package com.haobai.bytedance;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 11:43
 */
public class 字符串相加 {

    public String addStrings(String num1, String num2) {
        int n = num1.length() - 1, m = num2.length() - 1;
        int c = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        while (n >= 0 || m >= 0 || c > 0) {
            int sum1 = n >= 0 ? num1.charAt(n--) - '0' : 0;
            int sum2 = m >= 0 ? num2.charAt(m--) - '0' : 0;
            int sum = sum1 + sum2 + c;
            c = sum / 10;
            stack.push(sum % 10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
