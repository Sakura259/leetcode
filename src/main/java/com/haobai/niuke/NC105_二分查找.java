package com.haobai.niuke;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author haobai
 * @description:
 * @date 2021/2/21 14:35
 */
public class NC105_二分查找 {

    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 4, 5};
        new NC105_二分查找().search(ints, 4);
    }

    /**
     * 二分查找
     * 1、有序数组，因此最大的如果小于我们要查找的数，即为  n+1
     * 2、在left < right 的情况下，计算mid = left + （right - left） / 2 防溢出
     * 3、大于v  left = mid  + 1    小于mid， right = mid
     * 4、最后left == right就是我们要找的值
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // write code here
        int left = 0, right = nums.length - 1, index = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                index = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
