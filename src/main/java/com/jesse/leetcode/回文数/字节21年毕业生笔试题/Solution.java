package com.jesse.leetcode.回文数.字节21年毕业生笔试题;

/**
 * 输入一个字符串，将该字符串首尾相连成环，判断能否从中切进而产生回文
 * 输入：aab，输出Yes(切为aba)
 *
 * @author jesse hsj
 * @date 2020/7/4
 */
@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().isCirclePalindrome("baa"));
    }

    public boolean isCirclePalindrome(String s) {
        String ss = s + s;
        int length = s.length();
        String substring = ss.substring(1, ss.length() - 1);
        int subLength = substring.length();

        for (int i = 0; i < subLength; i++) {
            if (i+length <= subLength){
                if (isPalindrome(substring,i,i+length-1))
                    return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(String s, int left, int right) {
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
