package com.jesse.leetcode.BFSAndDFS.dfs.不同路径II;

import java.util.HashMap;
import java.util.Map;

/**
 * 相比1多了个障碍物
 *
 * @author jesse hsj
 * @date 2020/7/6 11:51
 */
public class Solution {

    public static void main(String[] args) {
        int[][] ob = new int[][]{
                {1}
        };
        System.out.println(new Solution().uniquePathsWithObstacles(ob));

    }

    int res = 0;
    Map<String, Integer> map = new HashMap<>();

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        backtrack(obstacleGrid, 1, 1);
        return res;
    }

    private void backtrack(int[][] obstacleGrid, int x, int y) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (x == m && y == n) {
            res++;
            return;
        }
        //向右走
        if (x + 1 <= m && obstacleGrid[x][y - 1] == 0) {
            if (map.containsKey((x + 1) + "_" + y)) {
                res += map.get((x + 1) + "_" + y);
            } else {
                int k = res;
                backtrack(obstacleGrid, (x + 1), y);
                map.put((x + 1) + "_" + y, res - k);
            }
        }

        //向下走
        if (y + 1 <= n && obstacleGrid[x - 1][y] == 0) {
            if (map.containsKey(x + "_" + (y + 1))) {
                res += map.get(x + "_" + (y + 1));
            } else {
                int k = res;
                backtrack(obstacleGrid, x, (y + 1));
                map.put(x + "_" + (y + 1), res - k);
            }
        }
    }

}
