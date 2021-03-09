package com.haobai.niuke;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/3/2 11:17
 */
public class NC73_数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        int mid = array.length / 2;
        int size = 0;
        for (int num : array) {
            if (num == array[mid]) {
                size++;
            }
        }
        if (size > array.length / 2) {
            return array[mid];
        } else {
            return 0;
        }
    }
}
