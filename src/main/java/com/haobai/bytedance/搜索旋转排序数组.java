package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/5 10:33
 */
public class 搜索旋转排序数组 {

    /**
     * 1、确定base case
     * 2、采用二分查找法
     * 2.1 判断  num[0] 和 num[mid] 的递增关系  再在里面  if-else判断是在哪个区间中
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
