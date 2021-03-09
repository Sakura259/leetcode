package com.haobai.niuke;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/3/7 16:04
 */
public class 最小堆_降序 {

    public static void main(String[] args) {
        int[] arr = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};
        new 最小堆_降序().minHeap_desc(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] minHeap_desc(int[] arr) {
        int length = arr.length - 1;
        for (int i = length / 2 - 1; i >= 0; i--) {
            minHeap_down(arr, i, length);
        }
        for (int i = length; i > 0; i--) {
            swap(arr, 0, i);
            minHeap_down(arr, 0, i - 1);
        }
        return arr;
    }

    private void minHeap_down(int[] arr, int start, int end) {
        int cur = start, left = cur * 2 + 1, temp = arr[cur];
        for (; left <= end; cur = left, left = 2 * cur + 1) {
            if (left < end && arr[left] > arr[left + 1]) {
                left++;
            }
            if (temp < arr[left]) {
                break;
            }
            arr[cur] = arr[left];
            arr[left] = temp;
        }
    }


    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
