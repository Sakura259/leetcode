package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/5 11:21
 */
public class x的平方根 {

    public int mySqrt(int x) {
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
