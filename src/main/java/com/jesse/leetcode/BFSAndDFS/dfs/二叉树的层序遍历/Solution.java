package com.jesse.leetcode.BFSAndDFS.dfs.二叉树的层序遍历;

import com.jesse.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jesse hsj
 * @date 2020/6/23
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(new Solution().levelOrder(treeNode));
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode node) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (node == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            ArrayList<Integer> result = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                result.add(treeNode.val);
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);
            }

            results.add(result);
        }
        //两个指针 一个指头 一个指尾
        Collections.reverse(results);
        return results;
    }

}
