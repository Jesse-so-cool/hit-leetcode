package com.jesse.leetcode.左右指针滑动窗口.字符串排列;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * @author jesse hsj
 * @date 2020/6/23 15:17
 */
public class Solution {
    public static void main(String[] args) {
        String S = "abcdxabcde",
                T = "abcdeabcdx";
        System.out.println(new Solution().checkInclusion(S, T));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char key = s1.charAt(i);
            if (need.containsKey(key)) {
                need.put(key, need.get(key) + 1);
            } else {
                need.put(key, 1);
            }
        }

        int left, right, valid;
        valid = left = right = 0;

        while (right < s2.length()) {
            char key = s2.charAt(right);
            right++;
            if (need.containsKey(key)) {
                if (window.containsKey(key)) {
                    window.put(key, window.get(key) + 1);
                } else {
                    window.put(key, 1);
                }
                if (window.get(key).equals(need.get(key))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size())
                    return true;
                //即将移出去的窗口
                char k = s2.charAt(left);
                left++;
                if (need.containsKey(k)) {
                    if (window.get(k).equals(need.get(k))) {
                        valid--;
                    }
                    window.put(k, window.get(k) - 1);
                }
            }
        }
        return false;
    }
}
