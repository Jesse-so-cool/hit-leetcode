package com.jesse.leetcode.左右指针滑动窗口.最长无重复子串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author jesse hsj
 * @date 2020/6/23 16:27
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right=0;
        int length = 0;
        Map<Character,Integer> window = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right ++;
            window.put(c,window.getOrDefault(c,0)+1);
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                left++;
                window.put(c1,window.getOrDefault(c1,0)-1);
            }
            length = Integer.max(length,right-left);
        }
        return length;
    }
}
