package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/4/2 14:26
 */
public class 下一个排列 {

    /**
     * 采用两次遍历的方式：
     * 第一次遍历：找到第一个不是降序的数x
     * 第二次遍历：找到第一个比x大的数
     * 交换位置
     * 然后 index = x + 1 后面是降序的，头尾交换位置，得到最小的值
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
