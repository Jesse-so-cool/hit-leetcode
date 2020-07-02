package com.jesse.leetcode.dp.背包问题.背包01;

/**
 * 描述：
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 *
 * 一个典型的动态规划问题。这个题目中的物品不可以分割，要么装进包里，要么不装，不
 * 能说切成两块装一半。这就是 0-1 背包这个名词的来历。
 * @author jesse hsj
 * @date 2020/6/15
 */
public class Solution {

    public static void main(String[] args) {
        int n = 3, w = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        System.out.println(new Solution().knapsack(w, n, wt, val));
    }

    //第一步要明确两点，「状态」和「选择」
    // 状态是   背包重量 和 可选择的东西
    // 选择是   对东西放进去还是不放进去，这个会影响背包重量
    // 定义dp  为dp[i][j] 代表在前i样可选择的东西，重量最大为j的情况下，可装入背包的最高价值
    int knapsack(int w, int n, int[] wt, int[] val) {
        //base case
        int dp[][] = new int[n+1][w+1];
        for (int i = 0; i <= w; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j-wt[i-1] < 0) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    int 选择i = dp[i-1][j-wt[i-1]] + val[i-1];
                    int 不选择i = dp[i-1][j];
                    dp[i][j] = Integer.max(选择i,不选择i);
                }

            }
        }
        
        return dp[n][w];
    }

}
