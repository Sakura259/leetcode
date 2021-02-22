package com.haobai.niuke;

import java.util.HashMap;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 10:36
 */
public class NC41_找到字符串的最长无重复字符子串 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5};
        System.out.println(new NC41_找到字符串的最长无重复字符子串().maxLength(arr));
    }

    /**
     * 这里不能用dp动态规划，会超时。它是有序的，采用start、end两个指针，当碰到一样的值，则将是start指针置为碰到的下一个相同数的位置  map.get(arr[end]) + 1
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int start = 0, end = 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])) {
                start = Math.max(start, map.get(arr[end]) + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(arr[end], end);
        }
        return max;
    }
}
