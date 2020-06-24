package com.jesse.leetcode.动态规划.最长递增序列;

/**
 * ？ 最优子在哪体现
 *
 * 经典动态规划题目
 * 1. 定义dp[i] 根据子序列常见套路 直接猜为以nums[i]为结尾的序列和
 *     那么题目要求的就是dp数组最大的那个值了
 * 2. 数学归纳法
 *      归纳出dp[i] = xxx
 *
 *
 * @author jesse hsj
 * @date 2020/6/15 13:56
 */
public class Solution {

    public static void main(String[] args) {
        int datas[] = {10,9,2,5,3,7,101,18};

        System.out.println(new Solution().lengthOfLIS(datas));
    }

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
