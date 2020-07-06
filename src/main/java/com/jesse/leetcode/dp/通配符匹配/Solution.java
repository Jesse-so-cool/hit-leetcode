package com.jesse.leetcode.dp.通配符匹配;

/**
 * @author jesse hsj
 * @date 2020/7/5
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "*"));
    }

    public boolean isMatch(String s, String p) {
        //定义dp[i][j] ：s的前i位和p的前j位是否匹配
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength +1][pLength +1];
        //base case
        //  dp[0][0] = true  if p[j]=='*' -> dp[0][j] = true
        dp[0][0] = true;
        for (int j = 0; j < pLength; j++) {
            if (p.charAt(j) == '*') {
                dp[0][j+1] = true;
            }else {
                break;
            }
        }

        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (p.charAt(j-1) == '*') {
                    //*情况 分为使用*和不使用*
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[sLength][pLength];
    }
}
