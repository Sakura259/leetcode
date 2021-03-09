package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/3/8 11:23
 */
public class NC30_数组中未出现的最小正整数 {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 4};
        new NC30_数组中未出现的最小正整数().minNumberdisappered(arr);
    }

    /**
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberdisappered(int[] arr) {
        // write code here
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] <= 0 || arr[i] > length) {
                arr[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            int index = Math.abs(arr[i]);

            if (index < length) {
                arr[index] = -Math.abs(arr[index]);
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] > 0 && arr[i] < length + 1) {
                res = i;
                break;
            }
        }
        return res == 0 ? length + 1 : res;
    }
}
