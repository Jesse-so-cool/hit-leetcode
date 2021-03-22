package com.jesse.leetcode.面经扣来的题.最长不重复子串;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2021/3/22 13:46
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int longest = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            window.put(r,window.getOrDefault(r,0)+1);
            right ++;
            while (window.get(r) > 1){
                char l = s.charAt(left);
                left++;

                window.put(l,window.get(l)-1);
            }
            longest = Math.max(longest,right-left);
        }
        return longest;

    }
}