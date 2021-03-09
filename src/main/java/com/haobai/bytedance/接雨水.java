package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 16:53
 */
public class 接雨水 {

    public int trap(int[] height) {
        int sum = 0;
        if (height.length < 3) {
            return sum;
        }
        int l = 0, r = height.length - 1;
        int wl = height[0], wr = height[r];
        while (l <= r) {
            if (l == r) {
                int wmin = Math.min(wl, wr);
                if (wmin > height[l]) {
                    sum += wmin - height[l];
                }
            }
            if (height[l] < height[r]) {
                if (wl > height[l]) {
                    sum += wl - height[l];
                } else {
                    wl = height[l];
                }
                l++;
            } else {
                if (wr > height[r]) {
                    sum += wr - height[r];
                } else {
                    wr = height[r];
                }
                r--;
            }
        }
        return sum;
    }
}
