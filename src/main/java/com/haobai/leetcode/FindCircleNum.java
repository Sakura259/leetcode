package com.haobai.leetcode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author haobai
 * @description:
 * @date 2020-11-11 22:51
 */
public class FindCircleNum {


    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int remove = queue.remove();
                    visited[remove] = 1;
                    for (int j = 0; j < visited.length; j++) {
                        if (M[remove][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
