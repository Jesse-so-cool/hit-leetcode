package com.jesse.leetcode.BFSAndDFS;

import com.jesse.leetcode.entity.MyTreeNode;

import java.util.Queue;
import java.util.Set;

/**
 * TODO
 *
 * @author jesse hsj
 * @date 2020/6/12 17:28
 */
public class BFS {

    int BFS(MyTreeNode start, MyTreeNode target) {
        Queue<MyTreeNode> q; // 核心数据结构
        Set<MyTreeNode> visited; // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);
        int step = 0; // 记录扩散的步数

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                MyTreeNode cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur == target)
                return step;
                /* 将 cur 的相邻节点加入队列 */
                for (MyTreeNode x : cur.adj())
                    if (x not in visited) {
                    q.offer(x);
                    visited.add(x);
                }
            }
            /* 划重点：更新步数在这里 */
            step++;
        }
    }

}
