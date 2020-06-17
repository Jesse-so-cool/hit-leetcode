package com.jesse.leetcode.动态规划.最长公共子序列;

/**
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 *
 * @author jesse hsj
 * @date 2020/6/17 15:46
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("abc","abc"));
    }

    //LCS算法:
    //子序列类型的问题，穷举出所有可能的结果都不容易，而动态规划算法做的就是穷举 + 剪枝，
    //  所以可以说只要涉及子序列问题，十有八九都需要动态规划来解决
    //LCS的解法是典型的二维动态规划，大部分比较困难的字符串问题都和这个问题一个套路，
    //  比如说编辑距离。
    public int longestCommonSubsequence(String text1, String text2) {

        //1. 定义dp[i][j]=x 对于i长度的text1和j长度的text2(直接截取) 最长公共子序列为x
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //2. 找到base case: dp[0][..] 和 dp[..][0] 都应该初始化为 0
        for (int i = 0; i <= text2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    continue;
                }
                int 选择i不在序列中 = dp[i-1][j];
                int 选择j不在序列中 = dp[i][j-1];
                dp[i][j] = Integer.max(选择i不在序列中,选择j不在序列中);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
