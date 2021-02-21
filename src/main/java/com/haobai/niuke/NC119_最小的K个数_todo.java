package com.haobai.niuke;

import java.util.ArrayList;

/**
 * @author haobai
 * @description:
 * @date 2021/2/21 14:53
 */
public class NC119_最小的K个数_todo {

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(new NC119_最小的K个数_todo().GetLeastNumbers_Solution(arr, 4));
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(16);
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int x = i;
            for (int j = i; j < input.length; j++) {
                if (min > input[j]) {
                    min = input[j];
                    x = j;
                }
            }
            int tmp = input[i];
            input[i] = input[x];
            input[x] = tmp;
            list.add(input[i]);
        }
        return list;
    }
}
