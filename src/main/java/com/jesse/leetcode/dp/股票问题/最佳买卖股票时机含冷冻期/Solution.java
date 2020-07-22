package com.jesse.leetcode.dp.股票问题.最佳买卖股票时机含冷冻期;

/**
 *
 * @author jesse hsj
 * @date 2020/7/10 11:30
 */
public class Solution {

    //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
    //dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])将冷冻期的状态加上
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp_pre_0;
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1,dp_pre_0-prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
