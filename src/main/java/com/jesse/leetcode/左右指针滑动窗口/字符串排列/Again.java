package com.jesse.leetcode.左右指针滑动窗口.字符串排列;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jesse hsj
 * @date 2020/8/12
 */
public class Again {
    //S1字串
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int size = s2.length();
        int valid = 0;

        while (right < size) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (need.get(c).equals(window.get(c)))
                    valid++;
            }
            //初步筛选只要是三个字符都可以 但是还是要在筛选的时候 为valid进行更新
            while (right - left == s1.length()) {
                if (valid == need.size())
                    return true;
                char c1 = s2.charAt(left);
                left++;

                if (need.containsKey(c1)){
                    if (need.get(c).equals(window.get(c)))
                        valid--;
                    window.put(c1,window.get(c1)-1);
                }

            }
        }
        return false;
    }
}
