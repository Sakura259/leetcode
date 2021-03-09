package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/3 09:45
 */
public class 数组中的第K个最大元素 {

    public int findKthLargest(int[] nums, int k) {
        return partition(nums, k, 0, nums.length - 1);
    }

    private int partition(int[] nums, int k, int l, int r) {
        if (l <= r) {
            int sort = quickSort(nums, l, r);
            if (sort == k - 1) {
                return nums[sort];
            } else if (sort > k - 1) {
                return partition(nums, k, l, sort - 1);
            } else {
                return partition(nums, k, sort + 1, r);
            }
        }
        return -1;
    }

    /**
     * 一次快速排序
     *
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private int quickSort(int[] nums, int l, int r) {
        int tmp = nums[l];
        while (l < r) {
            while (l < r && nums[r] <= tmp) {
                r--;
            }
            nums[l] = nums[r];
            while (l < r && nums[l] >= tmp) {
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }
}
