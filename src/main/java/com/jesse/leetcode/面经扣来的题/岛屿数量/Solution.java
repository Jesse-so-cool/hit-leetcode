package com.jesse.leetcode.面经扣来的题.岛屿数量;

/**
 * @author jesse hsj
 * @date 2021/3/22
 */
public class Solution {
    int res = 0;

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[0].length; i1++) {
                if (grid[i][i1] == '1') {
                    dfs(grid, i, i1);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row + 1, col);
        dfs(grid, row, col + 1);
    }
}
