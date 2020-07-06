package com.jesse.leetcode.BFSAndDFS.dfs.不同路径;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * @author jesse hsj
 * @date 2020/7/6 11:15
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(9, 11));
    }

    int res = 0;
    Map<String, Integer> map = new HashMap<>();

    public int uniquePaths(int m, int n) {
        //路径 选择
        backtrack(m, n, 1, 1);
        return res;
    }

    private void backtrack(int m, int n, int x, int y) {
        if (x == m && y == n) {
            res++;
            return;
        }
        //向右走
        if (x + 1 <= m) {
            if (map.containsKey((x + 1) + "_" + y)) {
                res += map.get((x + 1) + "_" + y);
            } else {
                int k = res;
                backtrack(m, n, (x + 1), y);
                map.put((x + 1) + "_" + y,res - k);
            }
        }

        //向下走
        if (y + 1 <= n){
            if (map.containsKey(x + "_" + (y+1))) {
                res += map.get(x + "_" + (y+1));
            } else {
                int k = res;
                backtrack(m, n, x, (y + 1));
                map.put(x + "_" + (y+1),res - k);
            }
        }
    }
}
