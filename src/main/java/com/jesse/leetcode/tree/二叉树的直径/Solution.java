package com.jesse.leetcode.tree.二叉树的直径;

import com.jesse.leetcode.entity.TreeNode;

/**
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * @author jesse hsj
 * @date 2020/7/21 10:37
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] nums = {3, 1, 4, null, 2};
        System.out.println(new Solution().diameterOfBinaryTree(TreeNode.create(nums)));
    }


    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left + right > res)
            res = left + right;
        return 1 + Integer.max(left, right);
    }
}
