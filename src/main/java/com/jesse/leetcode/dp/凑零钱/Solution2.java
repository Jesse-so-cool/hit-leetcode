package com.jesse.leetcode.dp.凑零钱;

/**
 * @author jesse hsj
 * @date 2020/7/2
 */
public class Solution2 {
    public static void main(String[] args) {
        int datas[] = {186, 419, 83, 408
        };
        System.out.println(new Solution2().coinChange(datas, 6249));
    }
    //dp 数组的迭代解法
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for (int i = 0; i < amount+1; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Integer.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}