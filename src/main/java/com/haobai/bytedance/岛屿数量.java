package com.haobai.bytedance;

/**
 * @author haobai
 * @description:
 * @date 2021/3/4 11:47
 */
public class 岛屿数量 {

    /**
     * DFS深度遍历
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int island_num = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return island_num;
        }
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    island_num++;
                    dfs(grid, i, j);
                }
            }
        }
        return island_num;
    }

    private void dfs(char[][] grid, int row, int col) {
        int maxRow = grid.length, maxCol = grid[0].length;

        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
    }
}
