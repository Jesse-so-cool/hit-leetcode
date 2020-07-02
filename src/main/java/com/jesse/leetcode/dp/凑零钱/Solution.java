package com.jesse.leetcode.dp.凑零钱;

import java.util.HashMap;
import java.util.Map;

/**
 * dp的递归算法
 * @author jesse hsj
 * @date 2020/6/14
 */
public class Solution {


    public static void main(String[] args) {
        int datas[] = {186,419,83,408
        };
        System.out.println(new Solution().coinChange(datas, 6249));
    }
    int[] coins;
    //dp的递归算法
    int coinChange(int[] coins, int amount) {
        this.coins = coins;
        return dp(amount);
    }

    Map<Integer,Integer> map = new HashMap<>();
    //超时
    private int dp(int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dp = dp(amount - coin);
            if (dp == -1) continue;
            res = Integer.min(res, 1 + dp);
        }
        if (res != Integer.MAX_VALUE )
            map.put(amount,res);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
