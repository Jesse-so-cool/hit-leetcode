package com.jesse.leetcode.BFSAndDFS.回溯算法.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2021/3/22 17:10
 */
public class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int i1 = 0; i1 < n; i1++) {
                sb.append(".");
            }
            list.add(sb.toString());
        }
        dfs(list,0);

        return res;
    }

    private void dfs(List<String> list, int row) {
        if (row == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = row; i < list.size(); i++) {

        }


    }
}
