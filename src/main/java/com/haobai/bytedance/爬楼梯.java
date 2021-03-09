package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/5 11:47
 */
public class 爬楼梯 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }
}
