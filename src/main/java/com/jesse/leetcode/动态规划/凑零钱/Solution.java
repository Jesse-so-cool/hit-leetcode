package com.jesse.leetcode.动态规划.凑零钱;

import static java.lang.Integer.min;

/**
 * @author jesse hsj
 * @date 2020/6/14
 */
public class Solution {

    int[] coins;

    public static void main(String[] args) {
        int datas[] = {1,5,10};
        System.out.println(new Solution().coinChange(datas, 11));
    }

    int coinChange(int[] coins, int amount) {
        this.coins = coins;
        return dp(amount);
    }

    private int dp(int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;


        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dp = dp(amount - coin);
            if (dp == -1) continue;

            res = min(res, 1 + dp);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
