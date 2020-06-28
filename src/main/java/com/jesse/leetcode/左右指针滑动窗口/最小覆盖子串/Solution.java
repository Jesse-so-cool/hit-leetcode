package com.jesse.leetcode.左右指针滑动窗口.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author jesse hsj
 * @date 2020/6/23 10:21
 */
public class Solution {


    public static void main(String[] args) {
        String S = "a", T = "aa";
        System.out.println(new Solution().minWindow(S, T));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (need.containsKey(key)) {
                need.put(key, need.get(key) + 1);
            } else {
                need.put(key, 1);
            }
        }

        int left, right, valid;
        valid = left = right = 0;

        int start = 0;
        int length = Integer.MAX_VALUE;
        int end = 0;
        while (right < s.length()) {
            char key = s.charAt(right);
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
            while (valid == need.size()) {
                if (right - left <= length) {
                    start = left;
                    end = right;
                    length = right - left;
                }
                //即将移出去的窗口
                char k = s.charAt(left);
                left++;
                if (need.containsKey(k)) {
                    if (window.get(k).equals(need.get(k))) {
                        valid--;
                    }
                    window.put(k, window.get(k) - 1);
                }
            }
        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}
