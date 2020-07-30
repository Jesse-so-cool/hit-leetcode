package com.jesse.leetcode.BFSAndDFS.bfs.二叉树的层次遍历II;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jesse hsj
 * @date 2020/7/19
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<LinkedList<Integer>> results = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> result = new LinkedList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                result.add(treeNode.val);
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);
            }

            results.addFirst(result);
        }
        res.addAll(results);
        return res;
    }

}
