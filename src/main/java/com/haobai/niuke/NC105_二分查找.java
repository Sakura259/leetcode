package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/21 14:35
 */
public class NC105_二分查找 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5};
        System.out.println(new NC105_二分查找().upper_bound_(5, 4, arr));
    }

    /**
     * 二分查找
     * 1、有序数组，因此最大的如果小于我们要查找的数，即为  n+1
     * 2、在left < right 的情况下，计算mid = left + （right - left） / 2 防溢出
     * 3、大于v  left = mid  + 1    小于mid， right = mid
     * 4、最后left == right就是我们要找的值
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        int left = 0, right = n - 1;
        if (a[right] < v) {
            return n + 1;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= v) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
    }
}
