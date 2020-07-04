package com.jesse.leetcode.回文数.是否为回文数;

/**
 * @author jesse hsj
 * @date 2020/7/4
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("qwq"));

    }

    public boolean isPalindrome(int x) {
        if (x < 0 ) return false;
        if (x < 10) return true;
        if (x % 10==0) return false;
        int reverse = 0;
        int k = 0;
        while (reverse < x) {
            k = x % 10;
            x = x / 10;
            if (x == reverse) {
                return true;
            }
            reverse = reverse * 10 + k;
        }

        return reverse == x;
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right])
                return false;
            left++;
            right--;
        }
        return true;
    }
}
