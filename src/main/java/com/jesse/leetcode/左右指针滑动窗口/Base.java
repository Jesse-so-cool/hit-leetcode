package com.jesse.leetcode.左右指针滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jesse hsj
 * @date 2020/6/23 10:21
 */
public class Base {


    public String slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            window.put(key,window.getOrDefault(key,0)+1);
        }

        int left, right, valid;
        valid = left = right = 0;

        //根据情况加下面的三个参数
        //int start = 0,end = 0;
        //int length = Integer.MAX_VALUE;
        // 判断左侧窗口是否要收缩
        while (right < s.length()) {
            char key = s.charAt(right);
            right++;
            //TODO 进行窗口内数据的一系列更新 这边为+

            //初步筛选后就可以进行对左边的窗口进行收缩
            while (valid == need.size()) {
                //即将移出去的窗口
                char k = s.charAt(left);
                left++;
                //TODO 进行窗口内数据的一系列更新 这边就为-（一般来说）
            }
        }
        //TODO 选择性返回
        return null;
    }
}
