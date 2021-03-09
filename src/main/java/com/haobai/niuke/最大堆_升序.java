package com.haobai.niuke;

import java.util.Arrays;

/**
 * @author haobai
 * @description:
 * @date 2021/3/7 15:46
 */
public class 最大堆_升序 {

    public static void main(String[] args) {
        int[] arr = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};
        new 最大堆_升序().maxHeap_asc(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void maxHeap_down(int[] arr, int start, int end) {
        int cur = start, left = 2 * start + 1, temp = arr[cur];
        for (; left <= end; cur = left, left = 2 * cur + 1) {
            if (left < end && arr[left + 1] > arr[left]) {
                left++;
            }
            if (temp > arr[left]) {
                break;
            }
            arr[cur] = arr[left];
            arr[left] = temp;
        }
    }

    private int[] maxHeap_asc(int[] arr) {
        int length = arr.length - 1;
        // 先构建最大堆
        for (int i = length - 1; i >= 0; i--) {
            maxHeap_down(arr, i, length);
        }
        // 构建完的最大堆  arr[0] 是最大的，因此和最后一个位置进行交换  arr[n] 是最大的，依次重新处理，得到最大堆
        for (int i = length; i > 0; i--) {
            swap(arr, i, 0);
            maxHeap_down(arr, 0, i - 1);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
