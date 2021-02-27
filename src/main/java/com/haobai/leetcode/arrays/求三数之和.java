package com.haobai.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haobai
 * @description:Three Sum（求三数之和）
 * 中文版：https://leetcode-cn.com/problems/3sum/
 * @date 2020-11-23 23:57
 */
public class 求三数之和 {

    public static void main(String[] args) {
//        List<List<Integer>> list = threeSum(new int[]{0, 2, 3, 4});
//        System.out.println(list);
    }

    private List<List<Integer>> list = new ArrayList<>(10);

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                twoSum(nums, i, length - 1);
            }
        }
        return list;
    }

    private void twoSum(int[] nums, int head, int tail) {
        int firstResult = nums[head++];
        boolean flag = false;
        while (head < tail) {
            if (flag && nums[head] == nums[head - 1]) {
                head++;
                continue;
            }
            int result = nums[head] + nums[tail] + firstResult;
            if (result == 0) {
                List<Integer> resultList = new ArrayList<>(3);
                resultList.add(firstResult);
                resultList.add(nums[head++]);
                resultList.add(nums[tail]);
                list.add(resultList);
                flag = true;
            } else if (result > 0) {
                tail--;
            } else {
                head++;
            }
        }
    }
}
