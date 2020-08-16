package com.jesse.leetcode.tree.最长同值路径;

import com.jesse.leetcode.entity.TreeNode;

/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 *
 * //好题
 * @author jesse hsj
 * @date 2020/7/29 11:51
 */
public class Solution {
    public static void main(String[] args) {
            Integer[] nums = {1, 4,5, 4, 4, 5};
            TreeNode t = TreeNode.create(nums);
            System.out.println(new Solution().longestUnivaluePath(t));
        }
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dp(root);
        return max;
    }
    private int dp(TreeNode root) {
        if (root == null){
            return 0;
        }
        int val = root.val;
        int left = dp(root.left);
        int right = dp(root.right);

        if (root.left != null && val == root.left.val && root.right != null && val == root.right.val) {
            max = Integer.max(max,left+right+2);
            return 1 + Integer.max(left,right);
        }
        if (root.left != null && val == root.left.val && (root.right == null || val != root.right.val)) {
            max = Integer.max(max,left+1);
            return 1 + left;
        }
        if (root.right != null && val == root.right.val && (root.left == null || val != root.left.val)) {
            max = Integer.max(max,right+1);
            return 1 + right;
        }

        return 0;
    }
}
