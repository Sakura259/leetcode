package com.haobai.leetcode.dynamicProgramming;

/**
 * @author haobai
 * @description: 509. 斐波那契数
 * @date 2020-12-07 23:00
 */
public class 斐波那契数 {

    public int fib(int N) {
        if (N  == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int x = 1, y = 1;
        for (int i = 3; i <= N; i++) {
            int temp = y;
            y += x;
            x = temp;
        }
        return y;
    }
}
