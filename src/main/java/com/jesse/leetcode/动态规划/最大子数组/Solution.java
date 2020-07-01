package com.jesse.leetcode.动态规划.最大子数组;

import java.util.Arrays;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 第一次可能会想到滑动窗口算法   滑动窗口就是专门处理子串/子数组问题的
 * @author jesse hsj
 * @date 2020/6/14
 */
public class Solution {
    public static void main(String[] args) {
        int datas[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(datas));
    }

    public int maxSubArray(int[] nums) {
        //定义dp  为以nums[i]结尾的最大子序和
        int[] dp = Arrays.copyOf(nums,nums.length);
        for (int i = 1; i < dp.length; i++) {
            int a = dp[i-1]+nums[i];
            dp[i] = Integer.max(a, nums[i]);
        }

        //所以最后的值就是在dp所有的值中选最大的
        int res = nums[0];
        for (int i = 0; i < dp.length; i++) {
            res = Integer.max(res , dp[i]);
        }

        return res;
    }
}
