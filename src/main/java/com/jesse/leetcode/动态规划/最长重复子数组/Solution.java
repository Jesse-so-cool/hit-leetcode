package com.jesse.leetcode.动态规划.最长重复子数组;

/**
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出: 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 *
 * @author jesse hsj
 * @date 2020/7/1 17:12
 */
public class Solution {

    //dp 表示包含自身的重复子数组长度为多少
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] dp = new int[A.length+1][B.length+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (A[i-1] == B[j-1])
                    dp[i][j] = dp[i-1][j-1]+1;
                max = Integer.max(dp[i][j],max);
            }
        }

        return max;
    }
}
