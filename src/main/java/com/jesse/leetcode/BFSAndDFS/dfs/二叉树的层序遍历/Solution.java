package com.jesse.leetcode.BFSAndDFS.dfs.二叉树的层序遍历;

import com.jesse.leetcode.entity.TreeNode;

import java.util.*;

/**
 * @author jesse hsj
 * @date 2020/6/23
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(new Solution().levelOrder(treeNode));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> result = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                result.add(treeNode.val);
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);
            }

            results.add(result);
        }
        return results;
    }

}
