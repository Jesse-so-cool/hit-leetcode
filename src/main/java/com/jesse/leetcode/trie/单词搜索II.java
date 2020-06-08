package com.jesse.leetcode.trie;

import com.google.gson.Gson;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jesse hsj
 * @date 2020/6/8
 */
public class 单词搜索II {
    char[][] board = null;
    Set<String> ans = new HashSet<>();
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'d', 'o', 'g', 'r'},
                {'i', 'o', 's', 'r'},
                {'i', 'g', 'l', 'v'}
        };
        String[] words = {"oath","pea","eat","dog","dogs"};
        Set<String> words1 = new 单词搜索II().findWords(board, words);
        System.out.println(new Gson().toJson(words1));
    }

    public Set<String> findWords(char[][] _board, String[] words) {
        Trie trie = new Trie();
        //创建trie
        for (String word : words) {
            trie.insert(word);
        }
        board = _board;

        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (trie.containsKey(board[row][col])) {
                    StringBuffer sb = new StringBuffer();
                    boolean[][] isVisited = new boolean[board.length][board[0].length];

                    //回溯
                    backtracking(row, col, trie, sb, isVisited);
                }
            }
        }
        return ans;
    }

    private void backtracking(int row, int col, Trie trie, StringBuffer sb, boolean[][] isVisited) {
        //退出回溯的条件，如果row和col是在边缘
        if(row>board.length-1||row<0||col<0||col>board[0].length-1) return;

        sb.append(board[row][col]);
        if (trie.search(sb.toString())) {
            ans.add(sb.toString());
        }
        isVisited[row][col] = true;
        if (trie.startsWith(sb.toString())) {
            backtracking(row+1,col,trie,sb,isVisited);
            backtracking(row-1,col,trie,sb,isVisited);
            backtracking(row,col+1,trie,sb,isVisited);
            backtracking(row,col-1,trie,sb,isVisited);
        }
        sb.deleteCharAt(sb.length()-1);
        isVisited[row][col]=false;

    }
}
