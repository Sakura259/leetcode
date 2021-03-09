package com.haobai.bytedance;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/3/8 00:00
 */
public class NC54_数组中相加和为0的三元组 {


    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num.length < 3) {
            return res;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (num[i] > 0) {
                break;
            }
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1, right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    res.add(list);
                    while (left < right && num[left] == num[left + 1]) {
                        left++;
                    }
                    while ((left < right) && num[right] == num[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
