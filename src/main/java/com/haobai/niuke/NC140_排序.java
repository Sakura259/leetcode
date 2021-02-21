package com.haobai.niuke;

import java.util.Arrays;

/**
 * @author haobai
 * @date 2021/2/20 16:13
 * <p>
 * 给定一个数组，请你编写一个函数，返回该数组排序后的形式。
 * <p>
 * 示例1
 * 输入
 * [5,2,3,1,4]
 * <p>
 * 返回值
 * [1,2,3,4,5]
 * <p>
 * 示例2
 * 输入
 * [5,1,6,2,5]
 * <p>
 * 返回值
 * [1,2,5,5,6]
 */
public class NC140_排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 23, 2, 4, 5};
        System.out.println(Arrays.toString(new NC140_排序().MySort(arr)));
    }

    /**
     * 快排解决
     * 左右哨兵
     *
     * @param arr
     * @return
     */
    public int[] MySort(int[] arr) {
        int i = 0, j = arr.length;
        quickSort(arr, i, j - 1);
        return arr;
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int i = l, j = r;
            int tmp = arr[i];
            while (i < j) {
                while (i < j && tmp < arr[j]) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                while (i < j && tmp > arr[i]) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }
            arr[i] = tmp;
            quickSort(arr, l, i - 1);
            quickSort(arr, i + 1, r);
        }
    }
}
