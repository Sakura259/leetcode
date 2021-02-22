package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 11:23
 */
public class NC22_合并两个有序的数组 {

    /**
     * 因为需要合并到A， 因此从大到小进行归并
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1;
        for (int index = m + n - 1; i >= 0 && j >= 0; index--) {
            A[index] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[j] = B[j--];
        }
    }
}
