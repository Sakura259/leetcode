package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/3/2 14:24
 */
public class NC128_容器盛水问题 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 2, 4};
        long l = new NC128_容器盛水问题().maxWater(arr);
        System.out.println(l);
    }

    /**
     * max water
     *
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0L;
        }
        long result = 0L;
        int l = 0, r = arr.length - 1;
        int wl = arr[0], wr = arr[r];
        while (l <= r) {
            if (l == r) {
                int wmin = Math.min(wl, wr);
                if (arr[l] < wmin) {
                    result += wmin - arr[l];
                }
            }
            if (arr[l] < arr[r]) {
                if (arr[l] < wl) {
                    result += wl - arr[l];
                } else {
                    wl = arr[l];
                }
                l++;
            } else {
                if (arr[r] < wr) {
                    result += wr - arr[r];
                } else {
                    wr = arr[r];
                }
                r--;
            }
        }
        return result;
    }
}
