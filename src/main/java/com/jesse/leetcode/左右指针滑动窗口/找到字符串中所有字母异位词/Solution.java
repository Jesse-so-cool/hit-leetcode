package com.jesse.leetcode.左右指针滑动窗口.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 *
 * @author jesse hsj
 * @date 2020/6/23 15:59
 */
public class Solution {
    public static void main(String[] args) {
        String S = "abcdxabcde",
                T = "abc";
        System.out.println(new Solution().findAnagrams(S, T));
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char key = p.charAt(i);
            need.put(key, need.getOrDefault(key, 0) + 1);
        }

        List<Integer> anagrams = new ArrayList<>();
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            right++;
            while (right - left >= p.length()) {
                if (valid == need.size())
                    anagrams.add(left);
                char t = s.charAt(left);
                left++;
                if (need.containsKey(t)) {
                    if (window.get(t).equals(need.get(t)))
                        valid--;
                    window.put(t, window.getOrDefault(t, 0) - 1);
                }

            }

        }
        return anagrams;

    }
}
