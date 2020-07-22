package com.jesse.leetcode.每日.三角形最小路径和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * @author jesse hsj
 * @date 2020/7/14 9:20
 */
public class Solution {

    public static void main(String[] args) {
    int[][] a = {
         {2},
        {3,4},
        {6,5,7},
        {4,1,8,3}
    };
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                li.add(a[i][j]) ;
            }
            triangle.add(li);
        }

        System.out.println(new Solution().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //路径 选择
        int height = triangle.size();
        //dp[i][j] 经过前i层 第j个的最小路径
        int[][] dp = new int[height+1][height+1];
        //dp[1][1] = triangle.get(0).get(0);

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= triangle.get(i-1).size(); j++) {
                if (j == 1) {
                    dp[i][j] = dp[i-1][j]+triangle.get(i-1).get(j-1);
                }else if (j == triangle.get(i-1).size()) {
                    dp[i][j] = dp[i-1][j-1]+triangle.get(i-1).get(j-1);
                }else {
                    dp[i][j] = Integer.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i-1).get(j-1);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= height; i++) {
            res = Integer.min(res,dp[height][i]);
        }
        return res;
    }

}
