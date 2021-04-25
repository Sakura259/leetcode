package com.haobai.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author haobai
 * @description:
 * @date 2021/4/7 23:15
 */
public class 合并区间 {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new 合并区间().merge(arr);
        System.out.println(Arrays.deepToString(merge));


    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merge = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (merge.size() == 0 || merge.get(merge.size() - 1)[1] < left) {
                merge.add(new int[]{left, right});
            } else {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], right);
            }
        }
        return merge.toArray(new int[merge.size()][2]);
    }
}
