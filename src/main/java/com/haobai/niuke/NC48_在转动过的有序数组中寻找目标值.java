package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/3/7 23:37
 */
public class NC48_在转动过的有序数组中寻找目标值 {

    /**
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] A, int target) {
        int length = A.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return A[0] == target ? 0 : -1;
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[left] <= A[mid]) {
                if (A[0] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
