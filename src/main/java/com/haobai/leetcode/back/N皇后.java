package com.haobai.leetcode.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haobai
 * @description: 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 * <p>
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * @date 2021/2/18 00:06
 */
public class N皇后 {

    private List<List<String>> result = new ArrayList<>(16);

    public List<List<String>> solveNQueens(int n) {
        char[][] track = new char[n][n];
        for (char[] i : track) {
            Arrays.fill(i, '.');
        }
        backTrack(track, 0);
        return result;
    }

    /**
     * 回溯算法框架
     *
     * @param track
     * @param row
     */
    private void backTrack(char[][] track, int row) {
        if (row == track.length) {
            result.add(arrayToList(track));
            return;
        }
        for (int col = 0; col < track.length; col++) {
            if (!isValid(track, row, col)) {
                continue;
            }
            track[row][col] = 'Q';
            backTrack(track, row + 1);
            track[row][col] = '.';
        }
    }

    /**
     * 判断是否满足N皇后的规则
     * 斜向方向的判断，是从0行开始处理，只需要左上方和左下方就可
     *
     * @param track
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(char[][] track, int row, int col) {
        int n = track.length;
        // 横线
        for (int i = 0; i < col; i++) {
            if (track[row][i] == 'Q') {
                return false;
            }
        }
        // 竖线
        for (int i = 0; i < row; i++) {
            if (track[i][col] == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (track[i][j] == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (track[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * 将数组转化成 字符创
     *
     * @param track
     * @return
     */
    private List<String> arrayToList(char[][] track) {
        List<String> result = new ArrayList<>(track.length);
        for (char[] i : track) {
            String s = new String(i);
            result.add(s);
        }
        return result;
    }
}
