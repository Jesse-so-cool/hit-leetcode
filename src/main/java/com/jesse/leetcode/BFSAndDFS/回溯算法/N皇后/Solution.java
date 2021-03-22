package com.jesse.leetcode.BFSAndDFS.回溯算法.N皇后;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * @author jesse hsj
 * @date 2021/3/22 17:10
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new Solution().solveNQueens(4)));
    }

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
        for (int i = 0; i < list.size(); i++) {

            if(!isValid(i,list,row)){
                continue;
            }
            set(list,row,i,"Q");
            dfs(list,row+1);
            set(list,row,i,".");
        }


    }

    private boolean isValid(int col, List<String> board, int row) {
        //竖着比较
        for (int j = 0; j < row; j++) {
            String s = board.get(j);
            char qIndex = s.charAt(col);
            if (qIndex == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }
    private void set(List<String> list, int row, int i, String q) {
        list.set(row,qString(list.size(),i,q));
    }
    private String qString(int size, int col, String q) {
        StringBuffer sb = new StringBuffer();
        for (int i1 = 0; i1 < size; i1++) {
            if (i1 == col) {
                sb.append(q);
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }
}
