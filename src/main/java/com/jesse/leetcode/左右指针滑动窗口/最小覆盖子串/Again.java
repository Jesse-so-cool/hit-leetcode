package com.jesse.leetcode.左右指针滑动窗口.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jesse hsj
 * @date 2020/8/12
 */
public class Again {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        System.out.println(new Again().minWindow(S, T));
    }

    public String minWindow(String s, String t) {

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int size = s.length();
        int valid = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        while (right < size) {
            char c = s.charAt(right);
            right++;
            //如果need不包含 那就直接continue
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            while (valid == need.size()) {
                System.out.println(s.substring(left, right));
                if (right - left < min) {
                    start = left;
                    end = right;
                    min = right - left;
                }
                char c1 = s.charAt(left);
                left++;

                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1)))
                        valid--;
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

}
