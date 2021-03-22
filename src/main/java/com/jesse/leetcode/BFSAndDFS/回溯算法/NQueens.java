package com.jesse.leetcode.BFSAndDFS.回溯算法;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse hsj
 * @date 2020/6/12 14:47
 */
public class NQueens {

    static List<List<String>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = 3;
        new NQueens().solute(n);
        System.out.println(new Gson().toJson(ans));
    }

    private void solute(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int i1 = 0; i1 < n; i1++) {
                sb.append("口");
            }
            list.add(sb.toString());
        }

        backtrack(list, 0);
    }


    private void backtrack(List<String> board, int row) {
        //满足结束条件
        if (row == board.size()) {
            List<String> res = new ArrayList<>(board);
            ans.add(res);
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (!isValid(col, board, row)) {
                continue;
            }
            //做选择
            board.set(row, qString(board.size(), col));

            backtrack(board,row+1);

            //撤销选择
            board.set(row, qString(board.size(), board.size()+1));

        }


    }

    private boolean isValid(int i, List<String> board, int row) {
        //竖着比较
        for (int j = 0; j < row; j++) {
            String s = board.get(j);
            int qIndex = s.indexOf("Q");
            if (qIndex == i) {
                return false;
            }
        }
        return true;
    }

    private String qString(int size, int col) {
        StringBuffer sb = new StringBuffer();
        for (int i1 = 0; i1 < size; i1++) {
            if (i1 == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

}
