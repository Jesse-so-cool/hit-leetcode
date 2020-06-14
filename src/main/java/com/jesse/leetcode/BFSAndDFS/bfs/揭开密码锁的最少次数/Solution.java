package com.jesse.leetcode.BFSAndDFS.bfs.揭开密码锁的最少次数;

import java.util.*;

/**
 * @author jesse hsj
 * @date 2020/6/13
 */
public class Solution {



    public static void main(String[] args) {


        String[] deadends = {"8888"};
        String target = "0009";
        System.out.println(new Solution().openLock(deadends, target));
    }


    public int openLock(String[] deadends, String target) {
        String lock = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(lock);
        int step = 0;
        Set<String> isVisited = new HashSet<>();
        isVisited.add(lock);
        Set<String> deads = new HashSet<>();
        List<String> collection = Arrays.asList(deadends);
        deads.addAll(collection);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (deads.contains(s)) continue;

                if (target.equals(s))
                    return step;

                for (int j = 0; j < 4; j++) {
                    String s1 = rotate(s, j, "+");
                    String s2 = rotate(s, j, "-");
                    if (!isVisited.contains(s1)) {
                        queue.offer(s1);
                        isVisited.add(s1);
                    }
                    if (!isVisited.contains(s2)) {
                        queue.offer(s2);
                        isVisited.add(s2);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    String rotate(String s, int index, String operate) {
        char[] chars = s.toCharArray();
        if (operate.equals("+")) {
            if (chars[index] == '9') {
                chars[index] = '0';
            } else {
                chars[index] += 1;
            }
        } else if (operate.equals("-")) {
            if (chars[index] == '0') {
                chars[index] = '9';
            } else {
                chars[index] -= 1;
            }
        } else {
            throw new RuntimeException();
        }
        return new String(chars);
    }

}
