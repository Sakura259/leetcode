package com.haobai.niuke;

import java.util.ArrayList;

/**
 * @author haobai
 * @description: 构造最大堆
 * @date 2021/2/21 14:53
 */
public class NC119_最小的K个数_todo {

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new NC119_最小的K个数_todo().GetLeastNumbers_Solution(arr, 4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(16);
        if (k > input.length || k == 0) {
            return list;
        }
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = input[i];
        }
        for (int i = (k - 1) / 2 - 1; i >= 0; i--) {
            maxHeap_down(heap, i, k - 1);
        }
        for (int i = k; i < input.length; i++) {
            if (input[i] >= heap[0]) {
                continue;
            }
            heap[0] = input[i];
            maxHeap_down(heap, 0, k - 1);
        }
        for (int i = 0; i < k; i++) {
            list.add(heap[i]);
        }
        return list;
    }

    private void maxHeap_down(int[] arr, int start, int end) {
        int cur = start, left = 2 * cur + 1, temp = arr[cur];
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
}
