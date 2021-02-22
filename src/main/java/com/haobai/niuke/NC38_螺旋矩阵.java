package com.haobai.niuke;

import java.util.ArrayList;

/**
 * @author haobai
 * @description:
 * @date 2021/2/22 22:57
 */
public class NC38_螺旋矩阵 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        // 判断临界问题
        if (matrix.length == 0) {
            return result;
        }
        // 行
        int rowEnd = matrix.length - 1;
        // 列
        int colEnd = matrix[0].length - 1;
        int rowStart = 0, colStart = 0;
        // 按右 下 左 上的顺序遍历
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;
            // down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;
            // left  需要进行判断
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;
            // up  需要进行判断
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return result;
    }
}
