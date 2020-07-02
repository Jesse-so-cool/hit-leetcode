package com.jesse.leetcode.dp.背包问题.子集背包问题.分割等和子集;

/**
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * @author jesse hsj
 * @date 2020/6/16
 */
public class Solution {

    public static void main(String[] args) {
        //int[] nums = {1,5,11,5,2};
        int[] nums = {2, 2, 3, 5};
        System.out.println(new Solution().canPartition(nums));

    }

    //分析：等和说明是加起来除以二 也就是是否存在两个数组加起来都等于sum/2
    //怎么转换为01背包问题？
    //可以反推为前i个物品物品重量刚好为sum/2
    //设计x = dp[i][j] 前i个物品物品重量 是否存在刚好子集和为sum/2
    boolean canPartition(int[] nums) {


        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        // 和为奇数时，不可能划分成两个和相等的集合
        if (sum2 % 2 != 0) return false;

        //base case 就是 dp[..][0] = true 和 dp[0][..] = false
        int sum = sum2 / 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    boolean 选择1 = dp[i - 1][j];//选择不把i放进去 那么x的值 取决于dp[i-1][j]
                    boolean 选择2 = dp[i - 1][j - nums[i - 1]];//选择把i放进去 那么x的值 取决于dp[i-1][j-nums[i-1]]
                    dp[i][j] = 选择1 || 选择2;
                }
            }
        }
        return dp[nums.length][sum];
    }
}