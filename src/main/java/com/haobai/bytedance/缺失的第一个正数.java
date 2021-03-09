package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/4 10:23
 */
public class 缺失的第一个正数 {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        new 缺失的第一个正数().firstMissingPositive(nums);
    }

    /**
     * 结果集只能出现在 1 - length + 1 中
     * 将小于0或者大于 length+1的都设置成 length+1
     * 然后去遍历，去改对应的下标为负数，最后遇到的第一个为正数的就是我们要的值
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0 || nums[i] > length + 1) {
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
