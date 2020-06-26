package com.jesse.leetcode.BFSAndDFS.回溯算法.括号生成;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new Solution().generateParenthesis(3)));
    }

    List<String> results = new ArrayList<>();
    String[] choices = {"(", ")"};

    public List<String> generateParenthesis(int n) {
        String track = "";
        int i = 0;
        //路径，选择列表
        backtrack(track, i, n);
        return results;
    }

    private void backtrack(String track, int i, int n) {
        if (!check(track, n))
            return;
        if (i == n * 2) {
            results.add(track);
            return;
        }
        for (int j = 0; j < choices.length; j++) {
            track += choices[j];
            backtrack(track, i + 1, n);
            track = track.substring(0, track.length() - 1);
        }
    }

    private boolean check(String track, int n) {
        int m = n, k = n;
        for (int i = 0; i < track.length(); i++) {
            String substring = track.substring(i, i + 1);
            if (substring.equals("(")) {
                m--;
            } else if (substring.equals(")")) {
                k--;
            }
        }
        if (m < 0 || k < 0)
            return false;
        if (m > k)
            return false;
        return true;
    }
}
