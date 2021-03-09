package com.haobai.niuke;

/**
 * @author haobai
 * @description:
 * @date 2021/3/8 11:38
 */
public class NC109_岛屿数量 {

    /**
     * 采用dfs进行深度遍历
     * <p>
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        int res = 0;
        // write code here
        int row = grid.length;
        if (row == 0) {
            return res;
        }
        int col = grid[0].length;
        if (col == 0) {
            return res;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol || grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
