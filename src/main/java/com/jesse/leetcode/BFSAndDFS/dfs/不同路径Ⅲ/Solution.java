package com.jesse.leetcode.BFSAndDFS.dfs.不同路径Ⅲ;

import com.google.gson.Gson;

import java.util.*;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/7/6 14:12
 */
public class Solution {

    public static void main(String[] args) {
        int[][] ints = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsIII(ints));
    }

    int res = 0;
    int[] start = new int[2];
    int zero = 0;
    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                }else if (grid[i][j] == 0) {
                    zero++;
                }
            }
        }
        List<String> set = new ArrayList<>();
        set.add(key(start[0],start[1]));
        //路径选择
        backtrack(grid,set,start[0],start[1]);
        return res;
    }

    private String key(int i, int j) {
        return i + "-" + j;
    }
    private void backtrack(int[][] grid, List<String> set, int x, int y) {
        if (grid[x][y] == 2) {
            //加上start和end
            if (zero+2 == set.size()) {
                res ++;
            }
            return;
        }

        //up
        if (x-1 >= 0 && !set.contains(key(x-1,y)) && grid[x][y] != -1) {
            set.add(key(x-1,y));
            backtrack(grid,set,x-1,y);
            set.remove(key(x-1,y));
        }
        //down
        if (x+1 <= grid.length-1 && !set.contains(key(x+1,y)) && grid[x][y] != -1) {
            set.add(key(x+1,y));
            backtrack(grid,set,x+1,y);
            set.remove(key(x+1,y));
        }
        //left
        if (y-1 >= 0 && !set.contains(key(x,y-1)) && grid[x][y] != -1) {
            set.add(key(x,y-1));
            backtrack(grid,set,x,y-1);
            set.remove(key(x,y-1));
        }
        //right
        if (y+1 <= grid[0].length-1 && !set.contains(key(x,y+1)) && grid[x][y] != -1) {
            set.add(key(x,y+1));
            backtrack(grid,set,x,y+1);
            set.remove(key(x,y+1));
        }

    }


}