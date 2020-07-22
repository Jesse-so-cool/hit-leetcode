package com.jesse.leetcode.dp.股票问题.买卖股票的最佳时机;

import java.util.Arrays;

/**
 * [7,1,5,3,6,4]
 * 输出: 5
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * @author jesse hsj
 * @date 2020/7/10 9:03
 */
public class Solution {

    public static void main(String[] args) {
        int prices[] = {7, 6, 4, 3, 1};
        System.out.println(new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        //int[][] dp = new int[prices.length + 1][2];//最大利润 可能为负
        //for (int i = 1; i <= prices.length; i++) {
        //    if (i == 1) {
        //        dp[i][0] = 0;
        //        dp[i][1] = -prices[0];
        //    } else {
        //        dp[i][0] = Integer.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
        //        dp[i][1] = Integer.max(dp[i - 1][1], -prices[i - 1]);
        //    }
        //}
        //        return dp[prices.length][0];


        // 新状态只和相邻的一个状态有关，其实不用整个 dp 数组，只需要一个变量储存相邻的那个状态就足够了，
        // 这样可以把空间复杂度降到 O(1):
        // 用一下代码替代
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;

    }
}
