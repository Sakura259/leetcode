package com.haobai.niuke;

import java.util.LinkedList;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 20:04
 */
public class NC1_大数加法 {

    /**
     * 大树加法，通过s.charAt()获取指定位置的数字。
     * 另外有一个c来记录仅为。
     * 每次把两个数相加在家仅为。
     * 除10 的结果为进位的结果， 余10的结果为当前位置的值。
     * <p>
     * 字符相减可以直接计算  '7' - '0' = 7
     * 把每一位的结果放在stack中。
     * 最后通过stringBuilder进行拼接。
     *
     * @param s
     * @param t
     * @return
     */
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
