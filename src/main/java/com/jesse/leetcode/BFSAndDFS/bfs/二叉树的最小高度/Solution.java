package com.jesse.leetcode.BFSAndDFS.bfs.二叉树的最小高度;

import com.jesse.leetcode.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jesse hsj
 * @date 2020/6/13
 */
public class Solution {

    public static void main(String[] args) {
        //TreeNode treeNode = TreeNode.create(new Integer[]{3,9,20,2,5,15,7,1,2,3,4,5,6,7});
        TreeNode treeNode = TreeNode.create(new Integer[]{1,2});
        System.out.println(new Solution().minDepth(treeNode));
    }


    int minDepth(TreeNode root) {
        if (root == null )   return 0;
        Queue<TreeNode> q = new LinkedList<>(); // 核心数据结构

        q.offer(root); // 将起点加入队列
        int step = 0; // 记录扩散的步数

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if ( cur.right == null && cur.left== null ){
                    step++;
                    return step;
                }
                /* 将 cur 的相邻节点加入队列 */
                if (cur.left!=null) q.offer(cur.left);;
                if (cur.right!=null) q.offer(cur.right);

            }
            /* 划重点：更新步数在这里 */
            step++;
        }
        return step;
    }

}
