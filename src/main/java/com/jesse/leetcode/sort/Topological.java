package com.jesse.leetcode.sort;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 拓扑排序
 *
 * @author jesse hsj
 * @date 2020/6/11
 */
public class Topological {

    public static void main(String[] args) {
        int[][] prerequisites = {
                {1,0},
                {3,2},
                {5,4}
        };
        System.out.println(new Topological().canFinish(6,prerequisites));
    }

    //广度优先+贪心算法 点解呢 明天搞
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        HashSet<Integer>[] adj = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] p : prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        // 首先加入入度为 0 的结点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // 记录已经出队的课程数量
        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt += 1;
            // 遍历当前出队结点的所有后继结点
            for (int successor : adj[top]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return cnt == numCourses;
    }

}
