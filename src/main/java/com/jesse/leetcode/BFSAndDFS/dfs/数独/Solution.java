package com.jesse.leetcode.BFSAndDFS.dfs.数独;

import com.google.gson.Gson;

/**
 * @author jesse hsj
 * @date 2020/6/14
 */
public class Solution {

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        System.out.println(new Solution().backtrack(board, 0, 0) == true);
        for (char[] chars : board) {
            System.out.println(new Gson().toJson(chars));
        }
    }

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {

        if (row == board.length) {
            return true;
        }
        //换行
        if (col == 9) {
            return backtrack(board,row+1,0);
        }

        //已经是初始的值
        if (board[row][col] != ('.')) {
            return backtrack(board,row,col+1);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board,row,col,c)) {
                continue;
            }
            board[row][col] = c;

            if (backtrack(board,row,col+1)){
                return true;
            }

            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;

    }


}
