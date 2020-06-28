package com.jesse.leetcode.BFSAndDFS.回溯算法.滑动拼图;

import java.util.*;

/**
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 *
 * 找出最少步数  -> BFS
 */
public class Solution {

    public static void main(String[] args) {
        int[][] board = {
                {1,2,3},
                {4,0,5}
        };

        System.out.println(new Solution().slidingPuzzle(board));
    }

    //Queue<List<List<Integer>>> queue = new LinkedList<>();  labuladong说这里比较复杂 所以不建议这样
    //所以转换为字符串
    public int slidingPuzzle(int[][] board) {
            String target = "123450";
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    sb.append(board[i][j]);
                }
            }
            String start = sb.toString();
            int[][] neighbor = {
                    {1,3},
                    { 0, 4, 2 },
                    { 1, 5 },
                    { 0, 4 },
                    { 3, 1, 5 },
                    { 4, 2 }
            };

            Queue<String> queue = new LinkedList<>();
            int step = 0;
            Set<String> isVisited = new HashSet<>();
            isVisited.add(start);
            queue.offer(start);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();
                    int zeroIndex = poll.indexOf("0");
                    int[] choices = neighbor[zeroIndex];

                    if (poll.equals(target)) {
                        return step;
                    }

                    for (int j = 0; j < choices.length; j++) {
                        //poll的i只为0 zeroIndex 编程choices[j]
                        StringBuffer s = new StringBuffer(poll);
                        s.setCharAt(zeroIndex,poll.charAt(choices[j]));
                        s.setCharAt(choices[j],'0');
                        String track = s.toString();
                        if (isVisited.contains(track)) {
                            continue;
                        }

                        queue.offer(track);
                        isVisited.add(track);
                    }
                }
                step++;
            }
            return -1;
    }
}
