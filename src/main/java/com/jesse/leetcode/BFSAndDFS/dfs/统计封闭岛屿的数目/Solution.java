package com.jesse.leetcode.BFSAndDFS.dfs.统计封闭岛屿的数目;

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jesse hsj
 * @date 2020/8/1
 */
public class Solution {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(new Gson().toJson(new Solution().closedIsland(nums)));
    }

    int k = 0, x = 0, y = 0, p = 0;
    static String split = "-";

    public int closedIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        x = grid.length;
        y = grid[0].length;
        Set<String> track = new HashSet();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 0) {
                    if (!track.contains(i + split + j)) {
                        p = 0;
                        track.add(i + split + j);
                        dfs(grid, i, j, track);
                        k++;
                        k -= p;
                    }
                }
            }
        }
        return k;
    }

    private void dfs(int[][] grid, int row, int col, Set<String> set) {
        if ((row > x - 1 || col > y - 1)
                || (row < 0 || col < 0)
                || (grid[row][col] == 1)) {
            set.remove(row + split + col);
            return;
        }
        if (row == 0 || col == 0 || row == x-1 || col == y-1) {
            p = 1;
        }
        String right = row + split + (col + 1);
        if (!set.contains(right)) {
            set.add(right);
            dfs(grid, row, col + 1, set);
        }

        String down = (row + 1) + split + (col);
        if (!set.contains(down)) {
            set.add(down);
            dfs(grid, row + 1, col, set);
        }
        String left = row + split + (col - 1);
        if (!set.contains(left)) {
            set.add(left);
            dfs(grid, row, col - 1, set);
        }
        String up = (row - 1) + split + (col);
        if (!set.contains(up)) {
            set.add(up);
            dfs(grid, row - 1, col, set);
        }
    }
}