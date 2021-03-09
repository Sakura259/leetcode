package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 23:46
 */
public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; i >= 0 && j >= 0; k++) {
            nums1[k] = nums1[i] >= nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[j] = nums2[j--];
        }
    }
}
