package com.jesse.leetcode.dp.最长有效括号;

/**
 * @author jesse hsj
 * @date 2020/7/4
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("((()))))"));
        System.out.println(new Solution().longestValidParentheses("((()(()))"));
        System.out.println(new Solution().longestValidParentheses(")()())"));
        System.out.println(new Solution().longestValidParentheses(""));
        System.out.println(new Solution().longestValidParentheses("()(()"));
    }

    //定义dp[i] 以i为结尾的最长有效括号
    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {//以(结尾 直接为0
                dp[i] = 0;
            }else if (chars[i-1] == '(') {//xxxxx() 这种情况直接=dp[i-2] + 2
                if (i - 2 >= 0)
                    dp[i] = dp[i-2] + 2;
                else dp[i] = 2;
            }else if (chars[i-1] == ')') {//xxxxx))
                if (i-dp[i-1]-1 >= 0 && chars[i-dp[i-1]-1] == '(') {//xxxxx)) 情况下只有在前面一位不为零，且他的有效括号前一位为(的情况下下 才有值
                    dp[i] = dp[i-1] + (i-dp[i-1]-2 >=0 ? dp[i-dp[i-1]-2] : 0) + 2;
                }else {
                    dp[i] = 0;
                }
            }
            res = Integer.max(res,dp[i]);
        }
        return res;
    }
}
