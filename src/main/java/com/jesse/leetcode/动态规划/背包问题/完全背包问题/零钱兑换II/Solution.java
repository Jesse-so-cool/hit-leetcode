package com.jesse.leetcode.动态规划.背包问题.完全背包问题.零钱兑换II;

/**
 * @description
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释: 有四种方式可以凑成总金额:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author jesse hsj
 * @date 2020/6/16
 */
public class Solution {

    public static void main(String[] args) {
        int amount = 1;
        int[] coins = {1,2,5};

        System.out.println(new Solution().change(amount, coins));
    }

        //同之前的背包问题类似 但是不同之处是可以重复放入背包中
    public int change(int amount, int[] coins) {

        //dp[i][j]=x 表示前i个物品 最多有x种方式使得背包重量为j
        //dp[i][0] = 1,dp[0][j] = 0
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int 选择i = 0;
                //TODO 这里我用了k 表示使用了几个i 但是labuladong没有用k 同样能解 表示疑问
                for (int k = 1; k < Integer.MAX_VALUE; k++) {
                    if (j-coins[i-1]*k >=0) {
                        选择i += dp[i-1][j-coins[i-1]*k];//选择i 说明
                    }else {
                        break;
                    }
                }
                //int 选择i = dp[i-1][j-coins[i-1]*k];//选择i 说明
                int 不选择i = dp[i-1][j];//选择i 说明

                dp[i][j] = 不选择i + 选择i;
            }
        }

        return dp[coins.length][amount];
    }
}
