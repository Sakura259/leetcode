package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 20:22
 */
public class NC103_反转字符串 {

    public String solve(String str) {
        int i = str.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0) {
            stringBuilder.append(str.charAt(i));
            i--;
        }
        return stringBuilder.toString();
    }
}
