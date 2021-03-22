package com.jesse.leetcode.左右指针滑动窗口.最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * @author jesse hsj
 * @date 2021/3/22 14:05
 */
public class AAgain {

    public static void main(String[] args) {
        String S = "asdvgfgfg", T = "ff";
        System.out.println(new AAgain().minWindow(S, T));
    }

    public String minWindow(String s, String t) {
        char[] needs = t.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : needs) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left=0, right = 0;
        int valid = 0;//一个key符合就+1
        int start = 0;//维护返回String的start下标
        int end = 0;//维护返回String的end下标
        int min = Integer.MAX_VALUE;//维护最小长度

        while (right < s.length()) {
            char r = s.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(need.get(r))) {
                    valid ++;
                }
            }

            while (valid == need.size()) {
                //只有在长度小于当前min时，才有必要维护start\end\min的值
                if (right - left < min) {
                    start = left;
                    end = right;
                    min = Integer.min(end-start,min);
                }
                char l = s.charAt(left);
                left++;
                if (need.containsKey(l)){
                    if (need.get(l).equals(window.get(l))){
                        valid--;
                    }
                    window.put(l, window.getOrDefault(l, 0) - 1);
                }
            }

        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}