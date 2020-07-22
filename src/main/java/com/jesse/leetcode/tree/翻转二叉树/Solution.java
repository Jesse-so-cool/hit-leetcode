package com.jesse.leetcode.tree.翻转二叉树;

import com.google.gson.Gson;
import com.jesse.leetcode.entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author jesse hsj
 * @date 2020/7/22 9:27
 */
public class Solution {

    public static void main(String[] args) {
            Integer[] nums = {4,2,7,1,3,6,9};
        TreeNode t = TreeNode.create(nums);
        System.out.println(new Gson().toJson(new Solution().invertTree2(t)));

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;

            if (poll.left != null){
                queue.offer(poll.left);
            }
            if (poll.right != null){
                queue.offer(poll.right);
            }
        }
        return root;

    }
}
