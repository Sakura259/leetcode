package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/25 16:17
 */
public class NC32_求平方根 {

    /**
     * @param x int整型
     * @return int整型
     */
    public int sqrt(int x) {
//        return (int) Math.sqrt(x);
        int left = 0, right = x, result = -1;
        while (left <= right) {
            // 避免大数相加溢出
            int mid = left + (right - left) / 2;
            // 需要变成 大数避免 大数溢出
            if ((long) mid * mid <= x) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
