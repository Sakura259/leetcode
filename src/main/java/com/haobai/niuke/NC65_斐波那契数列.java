package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/25 22:36
 */
public class NC65_斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(new NC65_斐波那契数列().Fibonacci(4));
    }

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int i = 0, j = 1;
        int result = 0;
        for (int k = 2; k <= n; k++) {
            result = i + j;
            i = j;
            j = result;
        }
        return result;
    }
}
